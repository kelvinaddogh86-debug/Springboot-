package shops.shops.errorresponds;

public class ErrorResponds {
    private String message;
    private String detalis;
    private  int  status;
    private String path;
    private long timestamp;

    public ErrorResponds(){}
    
    public ErrorResponds( String message,String details,int status,String path,long timestamp){
        this.message = message;
        this.detalis = details;
        this.status = status;
        this.path = path;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetalis() {
        return detalis;
    }

    public void setDetalis(String detalis) {
        this.detalis = detalis;
    }

    public int getStatus() {
        return status;
    }

    public void setStatuse(int status ){
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
        
    
}
