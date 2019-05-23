package under.the.bridge.pollingapp.model;

import java.util.List;

public class PollingData {

    /**
     * data : [{"id":1,"title":"Accusantium mollitia ullam cupiditate.","description":"Et nemo nemo odio ab laborum inventore. Autem porro ipsam accusamus. Tenetur culpa dolores quo molestiae rerum.","status":1,"type":"multi","average_rating":1,"created_at":"2019-05-21 05:11:00","updated_at":"2019-05-21 05:11:00","user":null,"ratings":[{"id":1,"user_id":7,"poll_id":1,"rating":1,"created_at":"2019-05-21 05:11:10","updated_at":"2019-05-21 05:11:10"}]},{"id":2,"title":"Est consequatur aliquid et.","description":"Vero quisquam officia distinctio iste eum molestiae aut rem. Aliquid voluptatum reprehenderit non aperiam.","status":1,"type":"multi","average_rating":4,"created_at":"2019-05-21 05:11:01","updated_at":"2019-05-21 05:11:01","user":null,"ratings":[{"id":2,"user_id":4,"poll_id":2,"rating":4,"created_at":"2019-05-21 05:11:10","updated_at":"2019-05-21 05:11:10"}]},{"id":3,"title":"Ullam reprehenderit doloribus dicta placeat.","description":"Quia nulla corrupti ipsum aut. Et alias harum repellendus molestiae voluptas voluptates. Quia ratione quasi autem eum id perferendis. In et provident sit error voluptate.","status":1,"type":"multi","average_rating":1,"created_at":"2019-05-21 05:11:01","updated_at":"2019-05-21 05:11:01","user":null,"ratings":[{"id":3,"user_id":6,"poll_id":3,"rating":1,"created_at":"2019-05-21 05:11:10","updated_at":"2019-05-21 05:11:10"}]},{"id":4,"title":"Dolorem cum architecto doloribus itaque odio omnis aut laudantium.","description":"A delectus fugiat unde est suscipit. Odit reiciendis atque dignissimos aut deleniti laboriosam. Explicabo qui ut numquam ut aut. Sint asperiores et et et placeat et at tenetur.","status":1,"type":"single","average_rating":3,"created_at":"2019-05-21 05:11:01","updated_at":"2019-05-21 05:11:01","user":null,"ratings":[{"id":4,"user_id":2,"poll_id":4,"rating":3,"created_at":"2019-05-21 05:11:10","updated_at":"2019-05-21 05:11:10"}]},{"id":5,"title":"Ea atque saepe quo doloribus officia quasi.","description":"Voluptas expedita quod rem eos autem aut. Sunt et dignissimos incidunt quos occaecati voluptatem molestiae. Illum est sit dolorem ipsam aut quia est. Aut nam sed impedit et qui molestiae fugit.","status":1,"type":"multi","average_rating":4,"created_at":"2019-05-21 05:11:02","updated_at":"2019-05-21 05:11:02","user":null,"ratings":[{"id":5,"user_id":5,"poll_id":5,"rating":4,"created_at":"2019-05-21 05:11:11","updated_at":"2019-05-21 05:11:11"}]},{"id":6,"title":"Animi dolorem quaerat minima a delectus sed.","description":"Quam voluptas sit laborum excepturi. Autem fugiat et expedita asperiores veritatis assumenda quam.","status":1,"type":"single","average_rating":4,"created_at":"2019-05-21 05:11:03","updated_at":"2019-05-21 05:11:03","user":null,"ratings":[{"id":6,"user_id":3,"poll_id":6,"rating":4,"created_at":"2019-05-21 05:11:11","updated_at":"2019-05-21 05:11:11"}]},{"id":7,"title":"Eum quasi veniam consequatur molestias qui.","description":"Ipsa molestias qui provident. Provident accusantium et fugiat iure. Sequi et repellat et nulla eos accusantium.","status":1,"type":"multi","average_rating":3,"created_at":"2019-05-21 05:11:04","updated_at":"2019-05-21 05:11:04","user":null,"ratings":[{"id":7,"user_id":6,"poll_id":7,"rating":3,"created_at":"2019-05-21 05:11:11","updated_at":"2019-05-21 05:11:11"}]},{"id":8,"title":"Sapiente fuga nostrum sed fuga.","description":"Veniam animi recusandae ex facilis blanditiis quia. Consectetur enim laudantium cupiditate aliquam numquam voluptatem. Laborum amet voluptatem veritatis voluptatibus ut ipsa.","status":1,"type":"multi","average_rating":1,"created_at":"2019-05-21 05:11:04","updated_at":"2019-05-21 05:11:04","user":null,"ratings":[{"id":8,"user_id":8,"poll_id":8,"rating":1,"created_at":"2019-05-21 05:11:11","updated_at":"2019-05-21 05:11:11"}]},{"id":9,"title":"Repudiandae doloremque omnis alias aut.","description":"Qui voluptas inventore dolores optio nisi laboriosam vel numquam. Corporis nihil nulla nulla nihil. Sint quo beatae est maxime et et asperiores dolor.","status":1,"type":"multi","average_rating":4,"created_at":"2019-05-21 05:11:04","updated_at":"2019-05-21 05:11:04","user":null,"ratings":[{"id":9,"user_id":9,"poll_id":9,"rating":4,"created_at":"2019-05-21 05:11:12","updated_at":"2019-05-21 05:11:12"}]},{"id":10,"title":"Doloribus quo fugit omnis facere.","description":"Aperiam perspiciatis et quas eos. Consequuntur ut sunt et maxime animi. Non qui pariatur facere vel totam ullam neque.","status":1,"type":"single","average_rating":5,"created_at":"2019-05-21 05:11:04","updated_at":"2019-05-21 05:11:04","user":null,"ratings":[{"id":10,"user_id":4,"poll_id":10,"rating":5,"created_at":"2019-05-21 05:11:12","updated_at":"2019-05-21 05:11:12"}]}]
     * links : {"first":"http://polling.esy.es/api/polls?page=1","last":"http://polling.esy.es/api/polls?page=6","prev":null,"next":"http://polling.esy.es/api/polls?page=2"}
     * meta : {"current_page":1,"from":1,"last_page":6,"path":"http://polling.esy.es/api/polls","per_page":10,"to":10,"total":51}
     */

    private LinksBean links;
    private MetaBean meta;
    private List<DataBean> data;

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class LinksBean {
        /**
         * first : http://polling.esy.es/api/polls?page=1
         * last : http://polling.esy.es/api/polls?page=6
         * prev : null
         * next : http://polling.esy.es/api/polls?page=2
         */

        private String first;
        private String last;
        private Object prev;
        private String next;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public Object getPrev() {
            return prev;
        }

        public void setPrev(Object prev) {
            this.prev = prev;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }
    }

    public static class MetaBean {
        /**
         * current_page : 1
         * from : 1
         * last_page : 6
         * path : http://polling.esy.es/api/polls
         * per_page : 10
         * to : 10
         * total : 51
         */

        private int current_page;
        private int from;
        private int last_page;
        private String path;
        private int per_page;
        private int to;
        private int total;

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    public static class DataBean {
        /**
         * id : 1
         * title : Accusantium mollitia ullam cupiditate.
         * description : Et nemo nemo odio ab laborum inventore. Autem porro ipsam accusamus. Tenetur culpa dolores quo molestiae rerum.
         * status : 1
         * type : multi
         * average_rating : 1
         * created_at : 2019-05-21 05:11:00
         * updated_at : 2019-05-21 05:11:00
         * user : null
         * ratings : [{"id":1,"user_id":7,"poll_id":1,"rating":1,"created_at":"2019-05-21 05:11:10","updated_at":"2019-05-21 05:11:10"}]
         */

        private int id;
        private String title;
        private String description;
        private int status;
        private String type;
        private int average_rating;
        private String created_at;
        private String updated_at;
        private Object user;
        private List<RatingsBean> ratings;

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

        public int getAverage_rating() {
            return average_rating;
        }

        public void setAverage_rating(int average_rating) {
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

        public Object getUser() {
            return user;
        }

        public void setUser(Object user) {
            this.user = user;
        }

        public List<RatingsBean> getRatings() {
            return ratings;
        }

        public void setRatings(List<RatingsBean> ratings) {
            this.ratings = ratings;
        }

        public static class RatingsBean {
            /**
             * id : 1
             * user_id : 7
             * poll_id : 1
             * rating : 1
             * created_at : 2019-05-21 05:11:10
             * updated_at : 2019-05-21 05:11:10
             */

            private int id;
            private int user_id;
            private int poll_id;
            private int rating;
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

            public int getPoll_id() {
                return poll_id;
            }

            public void setPoll_id(int poll_id) {
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
        }
    }
}
