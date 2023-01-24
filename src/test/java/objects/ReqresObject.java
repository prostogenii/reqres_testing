package objects;
public class ReqresObject {

        private String name;
        private String job;

        /**
         * No args constructor for use in serialization
         *
         */
        public ReqresObject() {
        }

        /**
         *
         * @param name
         * @param job
         */
        public ReqresObject(String name, String job) {
            super();
            this.name = name;
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

    }

