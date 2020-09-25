`Usage:`

`TapTargetView.showFor(this,                 // `this` is an Activity
    TapTarget.forView(findViewById(R.id.target), "This is a target", "We have the best targets, believe me")
        // All options below are optional
        .outerCircleColor(R.color.red)      // Specify a color for the outer circle
	    .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
        .targetCircleColor(R.color.white)   // Specify a color for the target circle
        .titleTextSize(20)                  // Specify the size (in sp) of the title text
        .titleTextColor(R.color.white)      // Specify the color of the title text
        .descriptionTextSize(10)            // Specify the size (in sp) of the description text
        .descriptionTextColor(R.color.red)  // Specify the color of the description text
        .textColor(R.color.blue)            // Specify a color for both the title and description text
        .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
        .dimColor(R.color.black)            // If set, will dim behind the view with 30% opacity of the given color
        .drawShadow(true)                   // Whether to draw a drop shadow or not
        .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view
        .tintTarget(true)                   // Whether to tint the target view's color
        .transparentTarget(false)           // Specify whether the target is transparent (displays the content underneath)
        .icon(Drawable)                     // Specify a custom drawable to draw as the target
        .targetRadius(60),                  // Specify the target radius (in dp)
    new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
        @Override
        public void onTargetClick(TapTargetView view) {
            super.onTargetClick(view);      // This call is optional
            doSomething();
        }
    });`