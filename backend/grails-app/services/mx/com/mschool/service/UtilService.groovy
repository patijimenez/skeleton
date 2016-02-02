package mx.com.mschool.service

import java.io.File
import java.text.Normalizer
import java.text.Normalizer.Form

class UtilService {

  def normalizeString(def str){
    def pattern = "[\\\\.,'´/_{}<>:;()*+?^\$|%#¿?!ᴬᴮᴱ¡=&\"|°¨º-]"
    str = Normalizer.normalize(str, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
    str.replaceAll(pattern, "")
  }

  def onlyNumbersAndLettersNormalized(def str){
    def pattern = "[^0-9a-zA-Z]"
    str = Normalizer.normalize(str, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
    str.replaceAll(pattern, "")
  }
}