define(["jquery","./TweenMax","./CSSPlugin"],function(e,t,n){(function(e){e.ScrollinAndTweenin=function(t,n){var r={animationValue:100,bottomOffset:1,tweens:[],stagger:!1,defaultStaggerValue:.2,defaultTweenDelay:0,defaultEaseType:Power2.easeOut,defaultProperty:"bottom",fadeIn:!1,ignoreDefaultTween:!1,hideAfterSet:!1,onTweenComplete:function(){}},i=this;i.settings={};var s=e(t),t=t,o=e(window),u=o.height(),a=new TimelineMax({paused:!0}),f,l;i.init=function(){var t=p();i.settings=e.extend({},r,n),i.settings.ignoreDefaultTween||s.css(i.settings.defaultProperty,"+="+i.settings.animationValue+"px");var c=s.offset(),d=c.top,v="-="+i.settings.animationValue+"px";f=i.settings.startPoint||d-u-i.settings.bottomOffset,l=i.settings.endPoint||d+i.settings.animationValue-u/2,i.settings.ignoreDefaultTween||a.append(TweenLite.to(s,1,{css:{bottom:v},delay:i.settings.defaultTweenDelay,ease:i.settings.defaultEaseType,onComplete:function(){i.settings.onTweenComplete()}})),i.settings.fadeIn&&(s.css("opacity",0),a.insert(TweenMax.to(s,1,{css:{opacity:1}})));if(i.settings.tweens.length>0){var m=0,g=i.settings.tweens.length;for(m;m<g;m+=1){var y=i.settings.tweens[m],b=y.property==="opacity"?0:y.startValue,w=y.property==="opacity"?1:y.endValue,E=typeof y.delay=="undefined"?0:y.delay,S=typeof y.ease=="undefined"?i.settings.defaultEaseType:y.ease;css={};if(y.property==="rotation"&&t)break;css[y.property]=w,y.property==="rotation"?(s.css("-webkit-transform","rotate("+b+"deg)"),s.css("transform","rotate("+b+"deg)")):s.css(y.property,b),a.insert(TweenMax.to(s,1,{css:css,delay:E,ease:S})),i.settings.hideAfterSet&&s.hide()}}o.scroll(function(){var e=o.scrollTop();h(f,l,e,a)})},i.stopAnimation=function(){a.pause()};var c=function(e){typeof console!="undefined"&&(console.log("++++++++++++++++++++"),console.log(e),console.log("++++++++++++++++++++"))},h=function(e,t,n,r){var o=1/(t-e)*(n-e);o>=0&&o<=1?(r.progress(o),i.settings.hideAfterSet&&!s.is(":visible")&&s.show()):o<0?(r.progress(0),i.settings.hideAfterSet&&s.is(":visible")&&s.hide()):o>1&&r.progress(1)},p=function(){var e=navigator.userAgent,t=/MSIE (\d+\.\d+);/;return t.test(e)};i.init()},e.fn.ScrollinAndTweenin=function(t){return this.each(function(){if(undefined==e(this).data("ScrollinAndTweenin")){var n=new e.ScrollinAndTweenin(this,t);e(this).data("ScrollinAndTweenin",n)}})}})(e)});