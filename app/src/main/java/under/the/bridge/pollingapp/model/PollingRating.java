package under.the.bridge.pollingapp.model;

public class PollingRating {
    /**
     * data : {"user_id":2,"poll_id":null,"rating":5,"created_at":"2019-05-23 08:06:20","updated_at":"2019-05-23 08:06:20","poll":{"id":1,"user_id":8,"title":"Accusantium mollitia ullam cupiditate.","description":"Et nemo nemo odio ab laborum inventore. Autem porro ipsam accusamus. Tenetur culpa dolores quo molestiae rerum.","status":1,"type":"multi","created_at":"2019-05-21 05:11:00","updated_at":"2019-05-21 05:11:00"}}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 2
         * poll_id : null
         * rating : 5
         * created_at : 2019-05-23 08:06:20
         * updated_at : 2019-05-23 08:06:20
         * poll : {"id":1,"user_id":8,"title":"Accusantium mollitia ullam cupiditate.","description":"Et nemo nemo odio ab laborum inventore. Autem porro ipsam accusamus. Tenetur culpa dolores quo molestiae rerum.","status":1,"type":"multi","created_at":"2019-05-21 05:11:00","updated_at":"2019-05-21 05:11:00"}
         */

        private int user_id;
        private Object poll_id;
        private int rating;
        private String created_at;
        private String updated_at;
        private PollBean poll;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public Object getPoll_id() {
            return poll_id;
        }

        public void setPoll_id(Object poll_id) {
            this.poll_id = poll_id;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public PollBean getPoll() {
            return poll;
        }

        public void setPoll(PollBean poll) {
            this.poll = poll;
        }

        public static class PollBean {
            /**
             * id : 1
             * user_id : 8
             * title : Accusantium mollitia ullam cupiditate.
             * description : Et nemo nemo odio ab laborum inventore. Autem porro ipsam accusamus. Tenetur culpa dolores quo molestiae rerum.
             * status : 1
             * type : multi
             * created_at : 2019-05-21 05:11:00
             * updated_at : 2019-05-21 05:11:00
             */

            private int id;
            private int user_id;
            private String title;
            private String description;
            private int status;
            private String type;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
