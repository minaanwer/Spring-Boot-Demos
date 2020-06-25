package fileupload.UI.Models;

import lombok.Data;

@Data
public class ResponseModel<T> {

    private String ResponseCode ;
    private String ResponseMessage;

    private T Data;

    public ResponseModel(String responseCode, String responseMessage, T data) {
        ResponseCode = responseCode;
        ResponseMessage = responseMessage;
        Data = data;
    }

    public ResponseModel() {
    }
}
