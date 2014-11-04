<!doctype html>
<html>
<head>
	<title>Pair Programming Matchmaking</title>
</head>

<body>
	<h1>Find a Pair</h1>

	<form name="find-pairs" action="/pairs" method="post">
		<p>
			<label>Location</label>
			<input name="location" type="text" />
		</p>

		<p>
			<input type="submit" value="find">
		</p>
	</form>

	<form name="add-session" action="/sessions/add" method="post">
		<h1>Add session</h1>

		<p>
			<br/>
			Name <input name="developerName" type="text"/> <br>
			Date <input name="date" type="text"/><br>
			Subject <input name="subject" type="text"/><br>
			Programming languages <input name="languages" type="text"/><br>
			Location <input name="location" type="text"/>

		</p>
		<p>
			<input type="submit" value="Add session"/>
		</p>
	</form>
	<p>
		<#if pairingSessions??>
			<#list pairingSessions as pairingSession>
				${pairingSession.developerName} <br>
			</#list>
		</#if>
	</p>
</body>
</html>