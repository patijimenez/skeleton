package mx.gob.inadem.shiro;

import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisCache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.grails.SavedHttpServletRequest;
import org.apache.shiro.session.Session;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.*;

public class RedisCacheManagerSerializable implements CacheManager {

  private static final Logger logger = LoggerFactory
      .getLogger(RedisCacheManagerSerializable.class);

  // fast lookup by name map
  private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();

  private RedisManager redisManager;

  /**
   * The Redis key prefix for caches
   */
  private String keyPrefix = "shiro_redis_cache:";

  /**
   * Returns the Redis session keys
   * prefix.
   * @return The prefix
   */
  public String getKeyPrefix() {
    return keyPrefix;
  }

  /**
   * Sets the Redis sessions key
   * prefix.
   * @param keyPrefix The prefix
   */
  public void setKeyPrefix(String keyPrefix) {
    this.keyPrefix = keyPrefix;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <K, V> Cache<K, V> getCache(String name) throws CacheException {
    logger.debug("RedisCacheManager: " + name + " RedisCache");
    Cache c = caches.get(name);

    if (c == null) {

      // initialize the Redis manager instance
      redisManager.init();

      // create a new cache instance
      c = new RedisCache<K, V>(redisManager, keyPrefix){
        public V put(K key, V value) {
          V result = value;

          if(value != null && value instanceof Session) {
            Session session = (Session) value;
            for(Object k : session.getAttributeKeys()) {
              Object object = session.getAttribute(k);
              if(object instanceof SavedHttpServletRequest) {
                SavedHttpServletRequest valueRequest = (SavedHttpServletRequest)object;
                object = new SerializableSavedRequest(valueRequest.getRequest());
              }
              session.setAttribute(k, object);
            }
          }

          return super.put(key, result);
        }
        public V get(K key) throws CacheException {
          V value = null;
          if (key == null) {
            return null;
          }else{
            value = super.get(key);
            if(value instanceof Session) {
              Session session = (Session)value;
              for(Object k : session.getAttributeKeys()) {
                Object object = session.getAttribute(k);
                if(object instanceof SerializableSavedRequest) {
                  SerializableSavedRequest valueRequest= (SerializableSavedRequest)object;
                  object = new SavedHttpServletRequest((HttpServletRequest)valueRequest.getRequest());
                  session.setAttribute(k, object);
                }
              }
            }

          }
          return value;
        }

      };

      // add it to the cache collection
      caches.put(name, c);
    }
    return c;
  }

  public RedisManager getRedisManager() {
    return redisManager;
  }

  public void setRedisManager(RedisManager redisManager) {
    this.redisManager = redisManager;
  }

}