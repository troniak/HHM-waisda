<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>
<tt:html>
<tt:head title="${game.video.title}">
	<script src="/static/script/ugslplayer.js"></script>
	<script src="/static/script/utils.js"></script>
	<script src="/static/script/videoplayer.js"></script>
	<script src="/static/script/taggingHistory.js"></script>
	<script src="/static/script/game.js"></script>
	<script src="/static/script/treehouse.js"></script>
</tt:head>
<tt:body cssClass="game" pageName="game">

<div class="equal-cols-game">
	
    <div id="gameCanvas" class="box span8 relative col-game leading">
        <div id="video-container">
            <!-- Video -->
            <video id="video" width="640" height="365">
                <source src="/static/videos/mikethefrog.mp4" type="video/mp4">
                <source src="/static/videos/mikethefrog.webm" type="video/webm">
                <source src="/static/videos/mikethefrog.ogv" type="video/ogv">
                <p>
                  Your browser doesn't support HTML5 video.
                  <a href="/videos/mikethefrog.mp4">Download</a> the video instead.
                </p>
            </video>
            <!-- Video Controls -->
            <div id="video-controls">
                <button type="button" id="play-pause">P</button>
                <input class="range" type="range" id="seek-bar"  value="0">
                <button type="button" id="step-back">&lt;</button>
                <button type="button" id="step-forward">&gt;</button>
                <button type="button" id="mute">M</button>
                <input type="range" id="volume-bar" min="0" max="1" step="0.1" value="1">
                <button type="button" id="full-screen">Full-Screen</button>
            </div>
            <div id="video-controls2">
                <input class="range" type="range" id="seek-bar2"  value="0" >
            </div>
            <div id="video-controls3">
                <input class="range" type="range" id="seek-bar3"  value="0" >
            </div>
        </div>
	</div>
	
</div>

<script type="text/javascript">
	jQuery(function() {
		<c:choose>
			<c:when test="${game.video.playerType == 'NPO'}">
				var video = {
						playerType : 'NPO',
						fragmentId : ${game.video.fragmentID},
						startTimeWithinEpisode : ${game.video.startTime},
						duration : ${game.video.duration}
					};
			</c:when>
			<c:when test="${game.video.playerType == 'JW'}">
				var video = {
						playerType : 'JW',
						sourceUrl : '${game.video.sourceUrl}',
						imageUrl : '${game.video.imageUrl}'
					};
			</c:when>
			<c:otherwise>
			var video = null;
			</c:otherwise>
		</c:choose>
		window.game = new Game(${game.id}, video, ${game.elapsed});
	});
</script>

</tt:body>
</tt:html>
