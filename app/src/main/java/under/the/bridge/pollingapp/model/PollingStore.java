package under.the.bridge.pollingapp.model;

import java.util.List;

public class PollingStore {
    /**
     * data : {"id":51,"title":"Polling Title 2","description":"Polling Description 2","average_rating":null,"created_at":"2019-05-23 07:17:01","updated_at":"2019-05-23 07:17:01","user":{"id":2,"name":"reza rahmansyah","email":"rezakozaze@gmail.com","google_id":"111458908115546468219","avatar":null,"avatar_original":null,"created_at":"2019-05-22 07:05:59","updated_at":"2019-05-22 07:05:59"},"ratings":[]}
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
         * id : 51
         * title : Polling Title 2
         * description : Polling Description 2
         * average_rating : null
         * created_at : 2019-05-23 07:17:01
         * updated_at : 2019-05-23 07:17:01
         * user : {"id":2,"name":"reza rahmansyah","email":"rezakozaze@gmail.com","google_id":"111458908115546468219","avatar":null,"avatar_original":null,"created_at":"2019-05-22 07:05:59","updated_at":"2019-05-22 07:05:59"}
         * ratings : []
         */

        private int id;
        private String title;
        private String description;
        private Object average_rating;
        private String created_at;
        private String updated_at;
        private UserBean user;
        private List<?> ratings;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public Object getAverage_rating() {
            return average_rating;
        }

        public void setAverage_rating(Object average_rating) {
            this.average_rating = average_rating;
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

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<?> getRatings() {
            return ratings;
        }

        public void setRatings(List<?> ratings) {
            this.ratings = ratings;
        }

        public static class UserBean {
            /**
             * id : 2
             * name : reza rahmansyah
             * email : rezakozaze@gmail.com
             * google_id : 111458908115546468219
             * avatar : null
             * avatar_original : null
             * created_at : 2019-05-22 07:05:59
             * updated_at : 2019-05-22 07:05:59
             */

            private int id;
            private String name;
            private String email;
            private String google_id;
            private Object avatar;
            private Object avatar_original;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getGoogle_id() {
                return google_id;
            }

            public void setGoogle_id(String google_id) {
                this.google_id = google_id;
            }

            public Object getAvatar() {
                return avatar;
            }

            public void setAvatar(Object avatar) {
                this.avatar = avatar;
            }

            public Object getAvatar_original() {
                return avatar_original;
            }

            public void setAvatar_original(Object avatar_original) {
                this.avatar_original = avatar_original;
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
