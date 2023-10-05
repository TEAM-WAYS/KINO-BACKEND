package ways.kinobackend.exceptions;

import java.util.Date;

    public class ErrorMessage {
        private int id;
        private Date timeStamp;
        private String message;
        private String description;

        public ErrorMessage(int id, Date timeStamp, String message, String description) {
            this.id = id;
            this.timeStamp = timeStamp;
            this.message = message;
            this.description = description;
        }

        public int getid() {
            return id;
        }

        public void setid(int id) {
            this.id = id;
        }

        public Date getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(Date timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

