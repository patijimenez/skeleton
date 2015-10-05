package mx.gob.inadem.service
import mx.gob.inadem.*

class MessageService {

    def findCallMessages(def callId) {
      def c = Call.load(callId)
      def mainMessages = MessageLegend.findAllByContextCallIsNull()
      def callMessages = MessageLegend.findAllByContextCall(c)
      def messages = mainMessages.collectEntries {
        [it.key, it.message]
      }

      callMessages.each {
        messages[it.key] = it.message
      }

      messages
    }

    def findAllMessages() {

        def callMessages = MessageLegend.findAll()
        def messages = [:]


        callMessages.each {

            def subMessages = [:]

            subMessages.put ("message",it.message)
            subMessages.put ("defaultMessage",it.defaultMessage)

            messages.put (it.key, subMessages)
        }

        messages
    }
}
