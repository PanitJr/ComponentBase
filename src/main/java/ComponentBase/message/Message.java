package ComponentBase.message;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by panit on 5/13/2016.
 */
@Entity
public class Message {
    private String header;
    private String content;
    private Boolean read = false;

    public Message() {
    }
    public Message(String header,String content){
        this.header = header;
        this.content = content;
    }


    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
