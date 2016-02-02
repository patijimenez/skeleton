package mx.com.mschool.exception

class ScriptException extends RuntimeException {
    String[] fields

    public ScriptException(String message) {
        super(message)
    }

    public ScriptException(String message, String[] fields) {
        super(message)
        this.fields = fields
    }

}
