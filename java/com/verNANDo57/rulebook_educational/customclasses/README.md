OnSwipeTouchListener Usage:

your_view.setOnTouchListener(new OnSwipeTouchListener(YourActivity.this) {
            public void onSwipeTop() {
                //Action
            }
            public void onSwipeRight() {
                //Action
            }
            public void onSwipeLeft() {
                //Action
            }
            public void onSwipeBottom() {
                //Action
            }

        });