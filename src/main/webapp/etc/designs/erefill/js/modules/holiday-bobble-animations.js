define(["jquery","stapes","../plugins/scrollin-and-tweenin/scrollin-and-tweenin"],function(e,t,n,r){function a(e){i.on("domready",f)}function f(){o=e("body").width(),s=e(".container").height()-344,u=e(".bobbles"),l()}function l(){e(".red-ball-small").ScrollinAndTweenin({ignoreDefaultTween:!0,tweens:[{property:"rotation",startValue:300,endValue:30,ease:Quad.easeOut},{property:"left",startValue:"-=50px",endValue:"+=50px",ease:Quad.easeOut}]}),e(".mirror-ball").ScrollinAndTweenin({tweens:[{property:"rotation",startValue:30,endValue:100,ease:Quad.easeOut,delay:.4},{property:"top",startValue:"+=60px",endValue:"-=60px",ease:Quad.easeOut,delay:.4},{property:"left",startValue:"-=30px",endValue:"+=30px",ease:Quad.easeOut,delay:.4}],ignoreDefaultTween:!0}),e(".red-ball-striped-hook").ScrollinAndTweenin({tweens:[{property:"rotation",startValue:90,endValue:30,ease:Quad.easeOut,delay:.4},{property:"top",startValue:"-=60px",endValue:"+=60px",ease:Quad.easeOut,delay:.4}],fadeIn:!0,ignoreDefaultTween:!0}),e(".red-ball-striped-ribbon").ScrollinAndTweenin({tweens:[{property:"rotation",startValue:50,endValue:0,ease:Quad.easeOut},{property:"top",startValue:"-=50px",endValue:"+=50px",ease:Quad.easeOut},{property:"right",startValue:"-=50px",endValue:"+=50px",ease:Quad.easeOut}],ignoreDefaultTween:!0}),e(".green-ball-striped").ScrollinAndTweenin({tweens:[{property:"rotation",startValue:50,endValue:0,ease:Quad.easeOut},{property:"top",startValue:"-=50px",endValue:"+=50px",ease:Quad.easeOut},{property:"right",startValue:"-=50px",endValue:"+=50px",ease:Quad.easeOut}],ignoreDefaultTween:!0})}var i,s,o,u,c=t.subclass({constructor:function(){i=this,a(),e(function(){i.emit("domready")})}});return new c});