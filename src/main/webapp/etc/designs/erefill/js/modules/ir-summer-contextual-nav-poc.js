define(["jquery","stapes"],function(e,t){var n={},r=t.subclass({constructor:function(t){var n=this;n.$mainWrapper=e(".ir-summer-nav"),n.$navWrappers=e(".ir-summer-nav > ul > li"),n.$navLinks=e(".ir-summer-nav > ul > li > a[href]"),n.$viewAll=e(".ir-summer-nav > ul .view-all a").first(),n.$triggers=e(".mega-carousel-trigger"),n.initEvents(),n.initStickiness(),e(function(){n.emit("domready")})},initEvents:function(){var t=this;t.$navLinks.on("click",function(n){n.preventDefault();var r=e(this),i=r.closest("li"),s;if(i.hasClass("active"))return;i.siblings(".active").removeClass("active"),s=i.data("category"),i.addClass("active"),t.hideDropdown(),t.emit("navLinkClicked",s)}),t.$navWrappers.hover(function(n){var r=e(this);r.addClass("hover"),t.preloadNavImages(r.find("img[data-original]"))},function(e){t.hideDropdown()}),t.$triggers.on("click",function(n){t.onTriggerClicked(e(this))}),t.on("domready",t.onDomReady)},initStickiness:function(){var t=this,n=e(window),r=t.$mainWrapper.offset().top,i=e(".nav-contextual"),s=function(){var e=n.scrollTop();e>r?(t.$mainWrapper.addClass("sticky-nav"),i.addClass("sticky-nav")):(t.$mainWrapper.removeClass("sticky-nav"),i.removeClass("sticky-nav"))};s(),n.scroll(function(){s(),t.emit("contextualNavScroll")})},onDomReady:function(){},preloadNavImages:function(t){var n=this,r=e(t),i=r.filter("img[data-original]");i.length>0&&i.each(function(t){n.doImagePreload(e(this))})},doImagePreload:function(e){var t=e.data("original"),n=e.siblings(".preloader");e.load(function(t){n.length>0&&n.addClass("fade-out"),e.removeAttr("data-original"),e.removeData("original"),e.removeClass("preloading"),e.addClass("preloaded fade-in")}),e.attr("src",t)},onTriggerClicked:function(e){var t=this,n=e.closest("li"),r=n.data("uid"),i=n.data("category");t.emit("contextualTriggerClicked",{category:i,uid:r}),t.$navWrappers.removeClass("hover")},setActiveButton:function(e){var t=this;if(!t.$navWrappers)return;t.$navWrappers.removeClass("active"),t.$navWrappers.filter("."+e).addClass("active")},hideDropdown:function(){var e=this;e.$navWrappers.removeClass("hover")},getNavButton:function(e){return self.$navLinks.find("[name="+e+"]")}});return function(e){return new r(e)}});