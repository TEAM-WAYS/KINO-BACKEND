package ways.kinobackend.DTO;

public class ApiResponse {
/*dto for api end point responses since i return instances of ApiResponse class
i can send JSON responses with a "message" field thus standardizing the responses
from backend access points
    */
    private String message;

    public ApiResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}