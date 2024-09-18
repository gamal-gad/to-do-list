class Task {
     private String title;
     private String description;
	 private boolean completed;

        public Task(String description) {
           
            this.description = description;
            this.completed = false;
        }
        public String getTitle() {
    		return title;
    	}
        
        public void setTitle(String title) {
    		this.title = title;
        }
        public void setDescription(String description) {
    		this.description = description;
    	}

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
    }
