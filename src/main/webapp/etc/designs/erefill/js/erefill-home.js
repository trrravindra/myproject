/*
 * jQuery FlexSlider v2.1
 * Copyright 2012 WooThemes
 * Contributing Author: Tyler Smith
 */

define("flexslider",["jquery"],function(e){!function(e){e.flexslider=function(t,n){var i=e(t),a=e.extend({},e.flexslider.defaults,n),o=a.namespace,r="ontouchstart"in window||window.DocumentTouch&&document instanceof DocumentTouch,s=r?"touchend":"click",l="vertical"===a.direction,d=a.reverse,c=0<a.itemWidth,u="fade"===a.animation,f=""!==a.asNavFor,p={};e.data(t,"flexslider",i),p={init:function(){i.animating=!1,i.currentSlide=a.startAt,i.animatingTo=i.currentSlide,i.atEnd=0===i.currentSlide||i.currentSlide===i.last,i.containerSelector=a.selector.substr(0,a.selector.search(" ")),i.slides=e(a.selector,i),i.container=e(i.containerSelector,i),i.count=i.slides.length,i.syncExists=0<e(a.sync).length,"slide"===a.animation&&(a.animation="swing"),i.prop=l?"top":"marginLeft",i.args={},i.manualPause=!1;var t,n=i;if((t=!a.video)&&(t=!u)&&(t=a.useCSS))e:{t=document.createElement("div");var o,s=["perspectiveProperty","WebkitPerspective","MozPerspective","OPerspective","msPerspective"];for(o in s)if(void 0!==t.style[s[o]]){i.pfx=s[o].replace("Perspective","").toLowerCase(),i.prop="-"+i.pfx+"-transform",t=!0;break e}t=!1}n.transitions=t,""!==a.controlsContainer&&(i.controlsContainer=0<e(a.controlsContainer).length&&e(a.controlsContainer)),""!==a.manualControls&&(i.manualControls=0<e(a.manualControls).length&&e(a.manualControls)),a.randomize&&(i.slides.sort(function(){return Math.round(Math.random())-.5}),i.container.empty().append(i.slides)),i.doMath(),f&&p.asNav.setup(),i.setup("init"),a.controlNav&&p.controlNav.setup(),a.directionNav&&p.directionNav.setup(),a.keyboard&&(1===e(i.containerSelector).length||a.multipleKeyboard)&&e(document).bind("keyup",function(e){e=e.keyCode,i.animating||39!==e&&37!==e||(e=39===e?i.getTarget("next"):37===e&&i.getTarget("prev"),i.flexAnimate(e,a.pauseOnAction))}),a.mousewheel&&i.bind("mousewheel",function(e,t){e.preventDefault();var n=0>t?i.getTarget("next"):i.getTarget("prev");i.flexAnimate(n,a.pauseOnAction)}),a.pausePlay&&p.pausePlay.setup(),a.slideshow&&(a.pauseOnHover&&i.hover(function(){!i.manualPlay&&!i.manualPause&&i.pause()},function(){!i.manualPause&&!i.manualPlay&&i.play()}),0<a.initDelay?setTimeout(i.play,a.initDelay):i.play()),r&&a.touch&&p.touch(),(!u||u&&a.smoothHeight)&&e(window).bind("resize focus",p.resize),setTimeout(function(){a.start(i)},200)},asNav:{setup:function(){i.asNav=!0,i.animatingTo=Math.floor(i.currentSlide/i.move),i.currentItem=i.currentSlide,i.slides.removeClass(o+"active-slide").eq(i.currentItem).addClass(o+"active-slide"),i.slides.click(function(t){t.preventDefault();var t=e(this),n=t.index();!e(a.asNavFor).data("flexslider").animating&&!t.hasClass("active")&&(i.direction=i.currentItem<n?"next":"prev",i.flexAnimate(n,a.pauseOnAction,!1,!0,!0))})}},controlNav:{setup:function(){i.manualControls?p.controlNav.setupManual():p.controlNav.setupPaging()},setupPaging:function(){var t,n=1;if(i.controlNavScaffold=e('<ol class="'+o+"control-nav "+o+("thumbnails"===a.controlNav?"control-thumbs":"control-paging")+'"></ol>'),1<i.pagingCount)for(var l=0;l<i.pagingCount;l++)t="thumbnails"===a.controlNav?'<img src="'+i.slides.eq(l).attr("data-thumb")+'"/>':"<a>"+n+"</a>",i.controlNavScaffold.append("<li>"+t+"</li>"),n++;i.controlsContainer?e(i.controlsContainer).append(i.controlNavScaffold):i.append(i.controlNavScaffold),p.controlNav.set(),p.controlNav.active(),i.controlNavScaffold.delegate("a, img",s,function(t){t.preventDefault();var t=e(this),n=i.controlNav.index(t);t.hasClass(o+"active")||(i.direction=n>i.currentSlide?"next":"prev",i.flexAnimate(n,a.pauseOnAction))}),r&&i.controlNavScaffold.delegate("a","click touchstart",function(e){e.preventDefault()})},setupManual:function(){i.controlNav=i.manualControls,p.controlNav.active(),i.controlNav.live(s,function(t){t.preventDefault();var t=e(this),n=i.controlNav.index(t);t.hasClass(o+"active")||(n>i.currentSlide?i.direction="next":i.direction="prev",i.flexAnimate(n,a.pauseOnAction))}),r&&i.controlNav.live("click touchstart",function(e){e.preventDefault()})},set:function(){i.controlNav=e("."+o+"control-nav li "+("thumbnails"===a.controlNav?"img":"a"),i.controlsContainer?i.controlsContainer:i)},active:function(){i.controlNav.removeClass(o+"active").eq(i.animatingTo).addClass(o+"active")},update:function(t,n){1<i.pagingCount&&"add"===t?i.controlNavScaffold.append(e("<li><a>"+i.count+"</a></li>")):1===i.pagingCount?i.controlNavScaffold.find("li").remove():i.controlNav.eq(n).closest("li").remove(),p.controlNav.set(),1<i.pagingCount&&i.pagingCount!==i.controlNav.length?i.update(n,t):p.controlNav.active()}},directionNav:{setup:function(){var t=e('<ul class="'+o+'direction-nav"><li><a class="'+o+'prev" href="#"></a></li><li><a class="'+o+'next" href="#"></a></li></ul>');i.controlsContainer?(e(i.controlsContainer).append(t),i.directionNav=e("."+o+"direction-nav li a",i.controlsContainer)):(i.append(t),i.directionNav=e("."+o+"direction-nav li a",i)),p.directionNav.update(),i.directionNav.bind(s,function(t){t.preventDefault(),t=e(this).hasClass(o+"next")?i.getTarget("next"):i.getTarget("prev"),i.flexAnimate(t,a.pauseOnAction)}),r&&i.directionNav.bind("click touchstart",function(e){e.preventDefault()})},update:function(){var e=o+"disabled";1===i.pagingCount?i.directionNav.addClass(e):a.animationLoop?i.directionNav.removeClass(e):0===i.animatingTo?i.directionNav.removeClass(e).filter("."+o+"prev").addClass(e):i.animatingTo===i.last?i.directionNav.removeClass(e).filter("."+o+"next").addClass(e):i.directionNav.removeClass(e)}},pausePlay:{setup:function(){var t=e('<div class="'+o+'pauseplay"><a></a></div>');i.controlsContainer?(i.controlsContainer.append(t),i.pausePlay=e("."+o+"pauseplay a",i.controlsContainer)):(i.append(t),i.pausePlay=e("."+o+"pauseplay a",i)),p.pausePlay.update(a.slideshow?o+"pause":o+"play"),i.pausePlay.bind(s,function(t){t.preventDefault(),e(this).hasClass(o+"pause")?(i.manualPause=!0,i.manualPlay=!1,i.pause()):(i.manualPause=!1,i.manualPlay=!0,i.play())}),r&&i.pausePlay.bind("click touchstart",function(e){e.preventDefault()})},update:function(e){"play"===e?i.pausePlay.removeClass(o+"pause").addClass(o+"play").text(a.playText):i.pausePlay.removeClass(o+"play").addClass(o+"pause").text(a.pauseText)}},touch:function(){function e(e){p=l?o-e.touches[0].pageY:o-e.touches[0].pageX,(!(v=l?Math.abs(p)<Math.abs(e.touches[0].pageX-r):Math.abs(p)<Math.abs(e.touches[0].pageY-r))||500<Number(new Date)-m)&&(e.preventDefault(),!u&&i.transitions&&(a.animationLoop||(p/=0===i.currentSlide&&0>p||i.currentSlide===i.last&&0<p?Math.abs(p)/f+2:1),i.setProps(s+p,"setTouch")))}function n(){if(t.removeEventListener("touchmove",e,!1),i.animatingTo===i.currentSlide&&!v&&null!==p){var l=d?-p:p,c=0<l?i.getTarget("next"):i.getTarget("prev");i.canAdvance(c)&&(550>Number(new Date)-m&&50<Math.abs(l)||Math.abs(l)>f/2)?i.flexAnimate(c,a.pauseOnAction):u||i.flexAnimate(i.currentSlide,a.pauseOnAction,!0)}t.removeEventListener("touchend",n,!1),s=p=r=o=null}var o,r,s,f,p,m,v=!1;t.addEventListener("touchstart",function(u){i.animating?u.preventDefault():1===u.touches.length&&(i.pause(),f=l?i.h:i.w,m=Number(new Date),s=c&&d&&i.animatingTo===i.last?0:c&&d?i.limit-(i.itemW+a.itemMargin)*i.move*i.animatingTo:c&&i.currentSlide===i.last?i.limit:c?(i.itemW+a.itemMargin)*i.move*i.currentSlide:d?(i.last-i.currentSlide+i.cloneOffset)*f:(i.currentSlide+i.cloneOffset)*f,o=l?u.touches[0].pageY:u.touches[0].pageX,r=l?u.touches[0].pageX:u.touches[0].pageY,t.addEventListener("touchmove",e,!1),t.addEventListener("touchend",n,!1))},!1)},resize:function(){!i.animating&&i.is(":visible")&&(c||i.doMath(),u?p.smoothHeight():c?(i.slides.width(i.computedW),i.update(i.pagingCount),i.setProps()):l?(i.viewport.height(i.h),i.setProps(i.h,"setTotal")):(a.smoothHeight&&p.smoothHeight(),i.newSlides.width(i.computedW),i.setProps(i.computedW,"setTotal")))},smoothHeight:function(e){if(!l||u){var t=u?i:i.viewport;e?t.animate({height:i.slides.eq(i.animatingTo).height()},e):t.height(i.slides.eq(i.animatingTo).height())}},sync:function(t){var n=e(a.sync).data("flexslider"),o=i.animatingTo;switch(t){case"animate":n.flexAnimate(o,a.pauseOnAction,!1,!0);break;case"play":!n.playing&&!n.asNav&&n.play();break;case"pause":n.pause()}}},i.flexAnimate=function(t,n,s,m,v){if(f&&1===i.pagingCount&&(i.direction=i.currentItem<t?"next":"prev"),!i.animating&&(i.canAdvance(t,v)||s)&&i.is(":visible")){if(f&&m){if(s=e(a.asNavFor).data("flexslider"),i.atEnd=0===t||t===i.count-1,s.flexAnimate(t,!0,!1,!0,v),i.direction=i.currentItem<t?"next":"prev",s.direction=i.direction,Math.ceil((t+1)/i.visible)-1===i.currentSlide||0===t)return i.currentItem=t,i.slides.removeClass(o+"active-slide").eq(t).addClass(o+"active-slide"),!1;i.currentItem=t,i.slides.removeClass(o+"active-slide").eq(t).addClass(o+"active-slide"),t=Math.floor(t/i.visible)}if(i.animating=!0,i.animatingTo=t,a.before(i),n&&i.pause(),i.syncExists&&!v&&p.sync("animate"),a.controlNav&&p.controlNav.active(),c||i.slides.removeClass(o+"active-slide").eq(t).addClass(o+"active-slide"),i.atEnd=0===t||t===i.last,a.directionNav&&p.directionNav.update(),t===i.last&&(a.end(i),a.animationLoop||i.pause()),u)r?(i.slides.eq(i.currentSlide).css({opacity:0,zIndex:1}),i.slides.eq(t).css({opacity:1,zIndex:2}),i.slides.unbind("webkitTransitionEnd transitionend"),i.slides.eq(i.currentSlide).bind("webkitTransitionEnd transitionend",function(){a.after(i)}),i.animating=!1,i.currentSlide=i.animatingTo):(i.slides.eq(i.currentSlide).fadeOut(a.animationSpeed,a.easing),i.slides.eq(t).fadeIn(a.animationSpeed,a.easing,i.wrapup));else{var g=l?i.slides.filter(":first").height():i.computedW;c?(t=a.itemWidth>i.w?2*a.itemMargin:a.itemMargin,t=(i.itemW+t)*i.move*i.animatingTo,t=t>i.limit&&1!==i.visible?i.limit:t):t=0===i.currentSlide&&t===i.count-1&&a.animationLoop&&"next"!==i.direction?d?(i.count+i.cloneOffset)*g:0:i.currentSlide===i.last&&0===t&&a.animationLoop&&"prev"!==i.direction?d?0:(i.count+1)*g:d?(i.count-1-t+i.cloneOffset)*g:(t+i.cloneOffset)*g,i.setProps(t,"",a.animationSpeed),i.transitions?(a.animationLoop&&i.atEnd||(i.animating=!1,i.currentSlide=i.animatingTo),i.container.unbind("webkitTransitionEnd transitionend"),i.container.bind("webkitTransitionEnd transitionend",function(){i.wrapup(g)})):i.container.animate(i.args,a.animationSpeed,a.easing,function(){i.wrapup(g)})}a.smoothHeight&&p.smoothHeight(a.animationSpeed)}},i.wrapup=function(e){!u&&!c&&(0===i.currentSlide&&i.animatingTo===i.last&&a.animationLoop?i.setProps(e,"jumpEnd"):i.currentSlide===i.last&&0===i.animatingTo&&a.animationLoop&&i.setProps(e,"jumpStart")),i.animating=!1,i.currentSlide=i.animatingTo,a.after(i)},i.animateSlides=function(){i.animating||i.flexAnimate(i.getTarget("next"))},i.pause=function(){clearInterval(i.animatedSlides),i.playing=!1,a.pausePlay&&p.pausePlay.update("play"),i.syncExists&&p.sync("pause")},i.play=function(){i.animatedSlides=setInterval(i.animateSlides,a.slideshowSpeed),i.playing=!0,a.pausePlay&&p.pausePlay.update("pause"),i.syncExists&&p.sync("play")},i.canAdvance=function(e,t){var n=f?i.pagingCount-1:i.last;return!!t||(!(!f||i.currentItem!==i.count-1||0!==e||"prev"!==i.direction)||(!f||0!==i.currentItem||e!==i.pagingCount-1||"next"===i.direction)&&(!(e===i.currentSlide&&!f)&&(!!a.animationLoop||(!i.atEnd||0!==i.currentSlide||e!==n||"next"===i.direction)&&(!i.atEnd||i.currentSlide!==n||0!==e||"next"!==i.direction))))},i.getTarget=function(e){return i.direction=e,"next"===e?i.currentSlide===i.last?0:i.currentSlide+1:0===i.currentSlide?i.last:i.currentSlide-1},i.setProps=function(e,t,n){var o,r=e||(i.itemW+a.itemMargin)*i.move*i.animatingTo;o=-1*function(){if(c)return"setTouch"===t?e:d&&i.animatingTo===i.last?0:d?i.limit-(i.itemW+a.itemMargin)*i.move*i.animatingTo:i.animatingTo===i.last?i.limit:r;switch(t){case"setTotal":return d?(i.count-1-i.currentSlide+i.cloneOffset)*e:(i.currentSlide+i.cloneOffset)*e;case"setTouch":return e;case"jumpEnd":return d?e:i.count*e;case"jumpStart":return d?i.count*e:e;default:return e}}()+"px",i.transitions&&(o=l?"translate3d(0,"+o+",0)":"translate3d("+o+",0,0)",n=void 0!==n?n/1e3+"s":"0s",i.container.css("-"+i.pfx+"-transition-duration",n)),i.args[i.prop]=o,(i.transitions||void 0===n)&&i.container.css(i.args)},i.setup=function(t){if(u)i.slides.css({width:"100%",float:"left",marginRight:"-100%",position:"relative"}),"init"===t&&(r?i.slides.css({opacity:0,display:"block",webkitTransition:"opacity "+a.animationSpeed/1e3+"s ease",zIndex:1}).eq(i.currentSlide).css({opacity:1,zIndex:2}):i.slides.eq(i.currentSlide).fadeIn(a.animationSpeed,a.easing)),a.smoothHeight&&p.smoothHeight();else{var n,s;"init"===t&&(i.viewport=e('<div class="'+o+'viewport"></div>').css({overflow:"hidden",position:"relative"}).appendTo(i).append(i.container),i.cloneCount=0,i.cloneOffset=0,d&&(s=e.makeArray(i.slides).reverse(),i.slides=e(s),i.container.empty().append(i.slides))),a.animationLoop&&!c&&(i.cloneCount=2,i.cloneOffset=1,"init"!==t&&i.container.find(".clone").remove(),i.container.append(i.slides.first().clone().addClass("clone")).prepend(i.slides.last().clone().addClass("clone"))),i.newSlides=e(a.selector,i),n=d?i.count-1-i.currentSlide+i.cloneOffset:i.currentSlide+i.cloneOffset,l&&!c?(i.container.height(200*(i.count+i.cloneCount)+"%").css("position","absolute").width("100%"),setTimeout(function(){i.newSlides.css({display:"block"}),i.doMath(),i.viewport.height(i.h),i.setProps(n*i.h,"init")},"init"===t?100:0)):(i.container.width(200*(i.count+i.cloneCount)+"%"),i.setProps(n*i.computedW,"init"),setTimeout(function(){i.doMath(),i.newSlides.css({width:i.computedW,float:"left",display:"block"}),a.smoothHeight&&p.smoothHeight()},"init"===t?100:0))}c||i.slides.removeClass(o+"active-slide").eq(i.currentSlide).addClass(o+"active-slide")},i.doMath=function(){var e=i.slides.first(),t=a.itemMargin,n=a.minItems,o=a.maxItems;i.w=i.width(),i.h=e.height(),i.boxPadding=e.outerWidth()-e.width(),c?(i.itemT=a.itemWidth+t,i.minW=n?n*i.itemT:i.w,i.maxW=o?o*i.itemT:i.w,i.itemW=i.minW>i.w?(i.w-t*n)/n:i.maxW<i.w?(i.w-t*o)/o:a.itemWidth>i.w?i.w:a.itemWidth,i.visible=Math.floor(i.w/(i.itemW+t)),i.move=0<a.move&&a.move<i.visible?a.move:i.visible,i.pagingCount=Math.ceil((i.count-i.visible)/i.move+1),i.last=i.pagingCount-1,i.limit=1===i.pagingCount?0:a.itemWidth>i.w?(i.itemW+2*t)*i.count-i.w-t:(i.itemW+t)*i.count-i.w-t):(i.itemW=i.w,i.pagingCount=i.count,i.last=i.count-1),i.computedW=i.itemW-i.boxPadding},i.update=function(e,t){i.doMath(),c||(e<i.currentSlide?i.currentSlide+=1:e<=i.currentSlide&&0!==e&&(i.currentSlide-=1),i.animatingTo=i.currentSlide),a.controlNav&&!i.manualControls&&("add"===t&&!c||i.pagingCount>i.controlNav.length?p.controlNav.update("add"):("remove"===t&&!c||i.pagingCount<i.controlNav.length)&&(c&&i.currentSlide>i.last&&(i.currentSlide-=1,i.animatingTo-=1),p.controlNav.update("remove",i.last))),a.directionNav&&p.directionNav.update()},i.addSlide=function(t,n){var o=e(t);i.count+=1,i.last=i.count-1,l&&d?void 0!==n?i.slides.eq(i.count-n).after(o):i.container.prepend(o):void 0!==n?i.slides.eq(n).before(o):i.container.append(o),i.update(n,"add"),i.slides=e(a.selector+":not(.clone)",i),i.setup(),a.added(i)},i.removeSlide=function(t){var n=isNaN(t)?i.slides.index(e(t)):t;i.count-=1,i.last=i.count-1,isNaN(t)?e(t,i.slides).remove():l&&d?i.slides.eq(i.last).remove():i.slides.eq(t).remove(),i.doMath(),i.update(n,"remove"),i.slides=e(a.selector+":not(.clone)",i),i.setup(),a.removed(i)},p.init()},e.flexslider.defaults={namespace:"flex-",selector:".slides > li",animation:"fade",easing:"swing",direction:"horizontal",reverse:!1,animationLoop:!0,smoothHeight:!1,startAt:0,slideshow:!0,slideshowSpeed:7e3,animationSpeed:600,initDelay:0,randomize:!1,pauseOnAction:!0,pauseOnHover:!1,useCSS:!0,touch:!0,video:!1,controlNav:!0,directionNav:!0,prevText:"Previous",nextText:"Next",keyboard:!0,multipleKeyboard:!1,mousewheel:!1,pausePlay:!1,pauseText:"Pause",playText:"Play",controlsContainer:"",manualControls:"",sync:"",asNavFor:"",itemWidth:0,itemMargin:0,minItems:0,maxItems:0,move:0,start:function(){},before:function(){},after:function(){},end:function(){},added:function(){},removed:function(){}},e.fn.flexslider=function(t){if(void 0===t&&(t={}),"object"==typeof t)return this.each(function(){var n=e(this),i=n.find(t.selector?t.selector:".slides > li");1===i.length?(i.fadeIn(400),t.start&&t.start(n)):void 0==n.data("flexslider")&&new e.flexslider(this,t)});var n=e(this).data("flexslider");switch(t){case"play":n.play();break;case"pause":n.pause();break;case"next":n.flexAnimate(n.getTarget("next"),!0);break;case"prev":case"previous":n.flexAnimate(n.getTarget("prev"),!0);break;default:"number"==typeof t&&n.flexAnimate(t,!0)}}}(e)}),define("modules/carousel",["jquery","stapes","flexslider"],function(e,t,n){"use strict";var i={NEXT:"next",PREVIOUS:"prev"},a={CUSTOM_CONTROLS_ERROR:"The element passed as a custom controls container does not meet the requirements. Please check that the wrapper you are passing in has two elements and that all class names are correct."},o={TAB:9,ENTER:13,ESC:27,SPACE:32,PAGEUP:33,PAGEDOWN:34,END:35,HOME:36,LEFT:37,UP:38,RIGHT:39,DOWN:40},r={el:null,renderDirectionNav:!1,customControls:null,isHero:!1,animation:"fade",slideshow:!0,preloadNextPrevImages:!1,controlNav:!0,startAt:0,slideshowSpeed:7e3,directionalControlsContainer:null,directionalControlButtons:".carousel-control-button",startAtRandom:!1,animationLoop:!0,pauseOnHover:!1,setupAoda:!1,manualControlsText:null,directionNavNextText:"",directionNavPreviousText:""},s=t.subclass({constructor:function(t){var n=this;n.config=e.extend({},r,t),n.el=e(n.config.el),n.isSingleSlide=!1,n.carouselLabel=n.config.carouselLabel||"",n.el.length&&(n.initEvents(),n.setupCarousel())},initEvents:function(){},setupCarousel:function(){var t=this,n=e(t.el),i=null;if(e(".slides > li",n).length<=1)return void t.onSingleSlide();t.config.directionalControlsContainer&&e(t.config.directionalControlsContainer).show(),t.config.startAtRandom&&(i=Math.floor(Math.random()*(n.find(".slides li[data-uid]").length-1))),n.flexslider({keyboard:!1,pauseOnHover:!0,directionNav:t.config.renderDirectionNav,controlsContainer:t.config.customControls,animation:t.config.animation,slideshow:t.config.slideshow,controlNav:t.config.controlNav,slideshowSpeed:t.config.slideshowSpeed,animationLoop:t.config.animationLoop,width:980,useCss:!1,startAt:i||t.config.startAt,start:function(e){t.config.directionalControlsContainer?t.setupDirectionalControls(e):t.onSliderReady(e),!0===t.config.setupAoda&&t.setupAcessibilityForCarousel(e)},before:function(e){t.onBeforeSlideChange(e)},after:function(e){t.onAfterSlideChange(e)},removed:function(e){t.onSlideRemoved(e)}}),n.hasClass("carousel-mlg")&&t.addSpacingToTitle()},setupDirectionalControls:function(t){var n=this,i=e(n.config.directionalControlsContainer),o=i.find(n.config.directionalControlButtons);if(!o.length||!i.length)throw n.onSliderReady(t),a.CUSTOM_CONTROLS_ERROR;o.on("click",function(t){t.preventDefault(),n.changeSlide(e(this).data("direction"))}),n.onSliderReady(t)},onSliderReady:function(e){var t=this;t.sliderElement=e,t.slideCount=t.sliderElement.count,t.currentSlideIndex=t.sliderElement.currentSlide,t.config.preloadNextPrevImages&&(t.isInited||(t.preloadFirstImages(),t.isInited=!0)),t.emit("sliderReady")},onSingleSlide:function(){var t=this,n=e(t.el),i=e(".slides > li",n);t.isSingleSlide=!0,i.show(),t.preloadSlide(i),t.config.directionalControlsContainer&&e(t.config.directionalControlsContainer).hide(),setTimeout(function(){t.emit("sliderReady")},100)},onBeforeSlideChange:function(e){var t=this,n=e.animatingTo;t.emit("beforeSlideChange"),t.config.preloadNextPrevImages&&(t.directionClicked===i.NEXT?t.preloadNextImages(n):t.preloadPreviousImages(n))},onAfterSlideChange:function(e){var t=this;e.animatingTo;t.$currentSlideWrapper=e.slides[t.getCurrentIndex()],t.emit("afterSlideChange",t.$currentSlideWrapper)},onSlideRemoved:function(e){var t=this;t.sliderElement=e,t.slideCount=t.sliderElement.count,t.currentSlideIndex=t.sliderElement.currentSlide,t.$currentSlideWrapper=t.sliderElement.slides[t.currentSlideIndex]},preloadSlide:function(t){var n=this,i=e(t),a=i.find("img[data-original]");a.length>0&&a.each(function(t){n.doImagePreload(e(this))})},preloadNextImages:function(t){var n=this;t++,n.slideCount<=t&&(t=0),n.preloadSlide(e(n.getSlideAtIndex(t)))},preloadPreviousImages:function(t){var n=this;t--,t<0&&(t=n.slideCount-1),n.preloadSlide(e(n.getSlideAtIndex(t)))},preloadFirstImages:function(){var t=this;if(t.config.preloadNextPrevImages){var n=e(t.sliderElement.slides[t.getCurrentIndex()]);t.preloadSlide(n),t.preloadNextImages(t.sliderElement.currentSlide),t.preloadPreviousImages(t.sliderElement.currentSlide)}},doImagePreload:function(e){var t=e.data("original"),n=e.siblings(".preloader");e.load(function(t){n.length>0&&n.addClass("fade-out"),e.removeAttr("data-original"),e.removeData("original"),e.removeClass("preloading"),e.addClass("preloaded fade-in")}),e.attr("src",t)},showHidePreloaders:function(e){var t=this,n=t.getSlideAtIndex(t.getCurrentIndex()),i=n.find(".preloaded"),a=i.siblings(".preloader");e?(a.removeClass("fade-out"),i.removeClass("fade-in")):(a.addClass("fade-out"),i.addClass("fade-in"))},changeSlide:function(e){var t=this;if(!t.isSingleSlide)if("string"==typeof e)if(t.directionClicked=e,e===i.NEXT)t.gotoNextSlide();else{if(e!==i.PREVIOUS)throw"You passed in a String that was not expected. Please check what you are passing into the changeSlide() method. The expected values are 'next', 'prev', or an integer.";t.gotoPrevSlide()}else"number"==typeof e&&t.gotoSlideFromIndex(e)},gotoNextSlide:function(){var e=this;if(!e.isSingleSlide){var t=e.getCurrentIndex()+1;e.sliderElement.slides.length<=t&&(t=0),e.emit("slideNext",e.getSlideAtIndex(t)),e.sliderElement.flexAnimate(t)}},gotoPrevSlide:function(){var e=this;if(!e.isSingleSlide){var t=e.getCurrentIndex()-1;t<0&&(t=e.sliderElement.slides.length-1),e.emit("slidePrevious",e.getSlideAtIndex(t)),e.sliderElement.flexAnimate(t)}},gotoSlideFromIndex:function(e){var t=this;if(!t.isSingleSlide&&(e>t.getListOfSlides().length&&(e=0),t.sliderElement.flexAnimate(e),t.currentSlideIndex=e,t.config.preloadNextPrevImages)){var n=t.getSlideAtIndex(e);t.preloadSlide(n),t.preloadNextImages(e),t.preloadPreviousImages(e)}},gotoFirstSlide:function(){var e=this;e.isSingleSlide||e.sliderElement.flexslider(0)},getCurrentIndex:function(){return self.isSingleSlide?0:Number(this.sliderElement.currentSlide)},getListOfSlides:function(){return this.sliderElement.slides},getSlideAtIndex:function(t){var n=this,i=n.getListOfSlides()[t];return e(i)},getCurrentSlide:function(){return e(this.getListOfSlides()[this.getCurrentIndex()])},getSlider:function(){return e(this.sliderElement)},addSpacingToTitle:function(){e(".slides .title").wrapInner("<span>"),e(".slides .title br").before("<span class='spacer'>").after("<span class='spacer'>")},setupAcessibilityForCarousel:function(t){var n=this,i=e(n.el),a=null,o=null,r=null,s=!1,l=n.getListOfSlides(),d=n.getCurrentIndex(),c=!1,u=n.config.el.replace(/[\.\s]+/,"-");n.config.controlNav&&null!==n.config.manualControlsText&&(n.setupAriaForControlNav(t),a=t.controlNav,t.controlNavScaffold,l=n.getListOfSlides(),c=!0),n.config.directionalControlsContainer&&(o=e(n.config.directionalControlsContainer),r=o.find(n.config.directionalControlButtons),o.length&&r.length&&(c=!0,s=!0)),!1===s&&!0===n.config.renderDirectionNav&&(console.log("Flex Direction setup"),o=i.find(".flex-direction-nav"),r=o.find("li a"),o.length&&r.length&&(console.log(r),console.log(n.config),n.config.directionNavNextText&&n.config.directionNavPreviousText&&(r.filter(".flex-prev").html('<span class="accessibility-hidden">'+n.config.directionNavPreviousText+"</span>"),r.filter(".flex-next").html('<span class="accessibility-hidden">'+n.config.directionNavNextText+"</span>")),c=!0,s=!0)),c&&(i.find(".slides").attr("id","slides-container-"+u),"string"==typeof n.config.animation&&"slide"===n.config.animation.toLowerCase()&&!0===n.config.animationLoop&&(i.find(".slides > li.clone").attr({"aria-hidden":!0}),i.find(".slides > li.clone :focusable").attr("tabindex",-1)),l.each(function(t){var n=e(this).attr("id");n||(n="slide-"+u+"-"+t),e(this).attr({"aria-hidden":"true",tabindex:-1}),e(this).find(":focusable").attr("tabindex",-1)}),l.eq(d).attr({"aria-hidden":"false",tabindex:0}),l.eq(d).find('[tabindex*="-1"]').attr("tabindex",0),n.on("afterSlideChange",function(e){var t=this,n=t.getCurrentIndex();l.each(function(e){e==n?(l.eq(e).attr({"aria-hidden":"false",tabindex:0}),l.eq(e).find(':focusable,[tabindex*="-1"]').attr("tabindex",0)):(l.eq(e).attr({"aria-hidden":"true",tabindex:-1}),l.eq(e).find(':focusable,[tabindex*="0"]').attr("tabindex",-1))})}),s&&(o.attr({"aria-role":"group","aria-label":"Carousel Controls","aria-controls":i.find(".slides").attr("id")}),r.attr({"aria-role":"button"})));var f,p=function(e){a&&a.is(":focus")?n.controlNavKeyboardHandler(e,a.filter(":focus"),t):l.is(":focus")?n.slidesKeyboardHandler(e,l.filter(":focus"),t):l.find(":focus").length&&n.slidesKeyboardHandler(e,l.find(":focus"),t),e.stopPropagation()},m=!1;n.on("beforeSlideChange",function(){m=!0}),i.on("focusin",function(e){i.data("focussedIn")||(i.data("focussedIn",!0),f=t.playing,!0===n.config.slideshow&&(t.pause(),t.manualPause=!0,f=!0),i.on("keyup",p))}),i.on("focusout",function(e){setTimeout(function(){i.find(":focus").length||(!0===n.config.slideshow&&(t.play(),t.manualPause=!1),i.removeData("focussedIn",!0),i.off("keyup",p))},10)})},setupAriaForControlNav:function(t){var n=this,i=(e(n.el),t.controlNav),a=t.controlNavScaffold,o=n.getListOfSlides(),r=n.config.manualControlsText,s=n.getCurrentIndex();a.attr("role","tablist"),a.find("li").attr("role","presentation"),o.attr("role","tabpanel");var l=n.config.el.replace(/[\.\s]+/,"-");o.each(function(t){var n=e(this).attr("id"),a="control-"+l+"-"+t;n||(n="slide-"+l+"-"+t,e(this).attr("id",n)),i.eq(t).attr({role:"tab","aria-selected":"false",tabindex:0,"aria-controls":n,href:"#"}).text(r+" "+(t+1)),e(this).attr({"aria-labelledby":a})}),i.click(function(e){e.preventDefault()}),o.eq(s).attr({"aria-hidden":"false",tabindex:0}),i.eq(s).attr({"aria-selected":"true",tabindex:0}),n.on("afterSlideChange",function(e){n.controlNavOnAfterSlideChange(i,o)})},controlNavOnAfterSlideChange:function(e,t){var n=this,i=n.getCurrentIndex();n.config.controlNav&&null!==n.config.manualControlsText&&e.each(function(t){t==i?e.eq(t).attr({"aria-selected":"true"}):e.eq(t).attr({"aria-selected":"false"})})},controlNavKeyboardHandler:function(e,t,n){var a,r=this,s=(r.getCurrentIndex(),n.controlNav),l=r.getListOfSlides(),d=function(){s.eq(r.getCurrentIndex()).focus(),r.off("afterSlideChange",d)},c=function(){l.eq(r.getCurrentIndex()).focus(),r.off("afterSlideChange",c)};e.which===o.LEFT||e.which===o.UP?(r.changeSlide(i.PREVIOUS),r.on("afterSlideChange",d),e.stopPropagation()):e.which===o.RIGHT||e.which===o.DOWN?(r.changeSlide(i.NEXT),r.on("afterSlideChange",d),e.stopPropagation()):e.which===o.SPACE?(a=s.index(t[0]),-1===a||t.hasClass("flex-active")?l.eq(r.getCurrentIndex()).focus():(r.changeSlide(a),r.on("afterSlideChange",c),e.stopPropagation())):e.which===o.ENTER&&(t.length&&(a=s.index(t[0])),-1!==a&&r.sliderElement.animating?r.on("afterSlideChange",c):l.eq(r.getCurrentIndex()).focus())},slidesKeyboardHandler:function(e,t,n){var a=this,r=(a.getCurrentIndex(),n.controlNav),s=a.getListOfSlides(),l=function(){r.eq(a.getCurrentIndex()).focus(),a.off("afterSlideChange",l)},d=function(){s.eq(a.getCurrentIndex()).focus(),a.off("afterSlideChange",d)};r&&e.which===o.UP&&(e.ctrlKey||e.altKey)?r.eq(a.getCurrentIndex()).focus():e.which===o.LEFT||e.which===o.UP?(a.changeSlide(i.PREVIOUS),a.on("afterSlideChange",d)):e.which===o.RIGHT||e.which===o.DOWN?(a.changeSlide(i.NEXT),a.on("afterSlideChange",d)):r&&e.which===o.PAGEUP&&e.altKey?(a.changeSlide(i.PREVIOUS),a.on("afterSlideChange",l)):r&&e.which===o.PAGEDOWN&&e.altKey&&(a.changeSlide(i.NEXT),a.on("afterSlideChange",l))},directionalNavKeyboardHandler:function(e,t,n){e.which===o.LEFT||e.which===o.UP?self.changeSlide(i.PREVIOUS):e.which!==o.RIGHT&&e.which!==o.DOWN||self.changeSlide(i.NEXT)}});return function(e){return new s(e)}}),define("erefill/mediators/home",["jquery","stapes","./globals","modules/api-tools","modules/carousel","../../modules/overlay","../../modules/managers/cookie-manager"],function(e,t,n,i,a,o,r){"use strict";return new(t.subclass({constructor:function(){var t=this;t.el=this&&this.document&&this.document.documentElement,t.getcontext=t.el&&t.attr(t.el,"data-context"),t.initEvents(),t.cookieManager=new r,e(function(){t.initCarousel(),t.emit("domready")})},initEvents:function(){var e=this;e.on("domready",e.onDomReady)},onDomReady:function(){var t=this,n=e("#require-js").attr("data-context");e(".alert.error.error-msg")&&e(".alert.error.error-msg").focus(),o.on("create",function(t){var n=o.getElement(),i=n.find(":focusable");i.first(),i.last();i.first().focus();var a=function(t){if(9===t.keyCode||27===t.keyCode){var n=e(this),i=n.find(":focusable,iframe"),a=i.first(),o=i.last();9==t.keyCode&&(o[0]===a[0]?t.preventDefault():!0===t.shiftKey&&t.target==a[0]?(t.preventDefault(),o.focus()):!1===t.shiftKey&&t.target==o[0]&&(t.preventDefault(),a.focus()))}};n.on("keydown",o,a)}),window.setTimeout(function(){localStorage.setItem("erefill-contextpath",n)},500);var i=e("html").attr("lang")||"en_CA";e("input[name='departments']").val(),e("input[name='proximity']").val(),e("input[name='stores']").val();480==screen.width&&640==screen.height&&(e(".card").css("marginRight","2px"),e(".card.article.quebecDisplay").css("width","320px"));var t=this;if(void 0===t.cookieManager.getCookieByName("erefill-selected-province")){var a=window.location.href,r=a.substring(a.indexOf("_CA")-2,a.indexOf("_CA")),s="/lcl-erefill-services/static/"+r+"_CA/userprovince.html";e.ajax({url:s,type:"GET",dataType:"html",cache:!1}).done(function(n){window.scrollTo(0,0),o.open({content:n,refresh:!0}),e(".overlay .close").remove(),e(".overlay .province").parent("div").css("min-width","400px"),e("body").on("touchmove",function(e){e.preventDefault()}),e(".form-details").find("button[type=submit]").on("click",function(n){n.preventDefault();var i=e(this).find("div").attr("data-province-value");t.cookieManager.setCookie("erefill-selected-province",i,"","/","",!0),location.reload()})})}var l=RegExp("erefillusername[^;]+").exec(document.cookie);l=unescape(l?l.toString().replace(/^[^=]+./,""):""),""!=l&&(e("#username").val(l),e("#remember").attr("checked",!0),e("#remember").parents().addClass("checked")),e("form.form-login").validate({ignore:[],errorClass:"error",onkeyup:!1,onclick:!1,onfocusout:!1,showErrors:function(t,n){e(".hero label.alert").removeClass("error error-msg"),e(".hero label.alert").hide(),this.defaultShowErrors(),n.length?(e(".hero").addClass("error"),e(".hero .error-msg").show(),e(".hero .error").attr("tabindex",0),e(".hero .error-msg").attr("tabindex",0),e(".hero .error-msg").focus(),window.setTimeout(function(){},500)):(e(".hero").removeClass("error"),e(".hero .error-msg").hide())}}),e("form.form-find-pharmacy").validate({errorClass:"error",onkeyup:!1,errorElement:"p",onclick:!1,onfocusout:!1,errorPlacement:function(e,t){e.insertBefore(t),e.attr("tabIndex","0"),e.focus()}}),e("form.form-find-pharmacy").on("submit",function(t){t.preventDefault();var a=e(this);e(".noresults",a).hide();var o=e(".input-search",a).val().replace(/\s/g,"");if(o){var r=n+"/"+i+"/store/location/"+o+"/department/300064/proximity/50/fetch/13";e.ajax({type:"GET",url:r,beforeSend:function(e){e.setRequestHeader("Content-Type","application/x-www-form-urlencoded"),e.setRequestHeader("Accept","application/json")},success:function(t){console.log("response for storeList");var n=JSON.parse(t.response);n.stores&&n.stores.length>0?(localStorage.setItem("erefill-storeloc",JSON.stringify(t)),a.get(0).submit()):(e(".noresults",a).show(),e(".noresults").attr("tabindex","0"),e(".noresults",a).focus())},fail:function(){
console.log("fail")}})}});var d=function(){return!!navigator.userAgent.match(/Trident.*rv[ :]*11\./)}();e(".help-close").on("click",function(t){t.preventDefault(),e("#overlay-wrap").hide(),e("#overlay-screen").hide(),e("body").removeAttr("style"),e("body").removeClass("overlay-on"),e("html").removeAttr("style")}),e(".help-modal").on("click",function(t){t.preventDefault(),d&&(e("#overlay-wrap .inner").addClass("innerIE11"),e("#overlay-wrap").addClass("wrapIE11")),e("#overlay-screen").show(),e("#overlay-wrap").show(),e("body").attr("style","overflow:hidden"),e("body").addClass("overlay-on")}),e("#overlay-screen").on("click",function(t){e("#overlay-wrap").hide(),e("#overlay-screen").hide(),e("body").removeAttr("style"),e("body").removeClass("overlay-on"),e("html").removeAttr("style")})},initCarousel:function(){var t=this,n=e(".carousel").data("carousel-conf"),i=a(n);t.set("carousel",i)}}))}),require(["require-config"],function(){require(["erefill/mediators/home"])}),define("erefill-home",function(){}),define("erefill-home",function(){});