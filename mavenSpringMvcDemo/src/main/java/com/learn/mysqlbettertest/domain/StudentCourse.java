package com.learn.mysqlbettertest.domain;
public class StudentCourse {
	
        private int id;
        private int sid;
        private int cid;
        private int score;
        
        public StudentCourse(int sid,int cid,int score) {
            this.sid = sid;
            this.cid = cid;
            this.score = score;
        }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getSid() {
			return sid;
		}

		public void setSid(int sid) {
			this.sid = sid;
		}

		public int getCid() {
			return cid;
		}

		public void setCid(int cid) {
			this.cid = cid;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
        
}