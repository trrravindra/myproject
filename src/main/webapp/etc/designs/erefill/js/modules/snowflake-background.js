define(["jquery","stapes","mediators/globals","../plugins/scrollin-and-tweenin/scrollin-and-tweenin","../modules/api-tools","json!config"],function(e,t,n,r,i,s){function p(e){o.on("domready",d)}function d(){a=e("body").width(),u=e(".container").height()+100,h=e("html").hasClass("lt-ie9"),c=e(".snowflakes"),c.css({height:u}).addClass("hidden");var t=Math.floor(u/100);t=t>30?30:t,m(t)}function v(){function r(e){return~~(Math.random()*e)}function i(){var e={left:r(a-t),top:r(u-t),opacity:Modernizr.svg?Math.random():1};return e}function o(){return s[r(s.length-1)]}function f(e){for(var t=0;t<n.length;t++){var r=n[t],i=e.y+e.height,s=r.y+r.height,o=e.y,u=r.y,a=e.x,f=r.x,l=e.x+e.width,c=r.x+r.width;if(i<u||o>s||l<f||a>c)continue;return!0}return!1}l=e(".snowflake");var t=100,n=[],s=[{width:t*2,height:t*2},{width:t*2.5,height:t*2.5},{width:t*2.25,height:t*2.25},{width:t*3.5,height:t*3.5},{width:t*1.25,height:t*1.25},{width:t*1.5,height:t*1.5},{width:t*1.33,height:t*1.33},{width:t*1.75,height:t*1.75}];l.each(function(t,r){var s,u;do s=i(t),size=o(),u={x:s.left,y:s.top,width:size.width,height:size.height};while(f(u));n.push(u);var a=e(r);s.width=s.height=size.height,a.css(s)}),Modernizr.touch?c.fadeIn():(c.ScrollinAndTweenin({ignoreDefaultTween:!0,tweens:[{property:"top",startValue:"-=466px",endValue:"+=1000px",ease:"Quart.easeOut"}],startPoint:-1e3,endPoint:1e4}),e("html, body").animate({scrollTop:"+=1"},function(e){h||c.fadeIn(),c.removeClass("hidden")}))}function m(t){function o(){for(n;n<r;n+=1){var t=e('<img class="snowflake" src="/library/images/insiders-report/holiday/decal-snowflake.png">');c.append(t)}v()}var n=0,r=t||_config.numSnowflakes;if(Modernizr.svg){var i=s.pcplus&&s.pcplus.snowflakeBackgroundGraphicPath?s.pcplus.snowflakeBackgroundGraphicPath:"content/lclonline/config/en_CA/hir/snowflake.html";e.ajax(i).done(function(e){for(n;n<r;n+=1)c.append(e);v()}).fail(o)}else o()}var o,u,a,f={numSnowflakes:20},l,c,h=!1,g=t.subclass({constructor:function(t){o=this,_config=e.extend({},f,t),p(),e(function(){o.emit("domready")})}});return function(e){return new g(e)}});