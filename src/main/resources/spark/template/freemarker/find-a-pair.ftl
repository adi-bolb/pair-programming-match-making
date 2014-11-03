<!doctype html>
<html>
<head>
	<title>Pair Programming Matchmaking</title>
</head>

<body>
	<h1>Find a Pair</h1>

	<form action="/pairs" method="post">
		<p>What do you want to do:
			<br/>
			<textarea placeholder="TDD kata on Bowling score"></textarea>
		</p>

		<p>
			<input type="submit" value="find">
		</p>
	</form>
	<form action="/sessions/add" method="post">
		<h1>Add session</h1>

		<p>
			<br/>
			Name <input id="name" type="text"/> <br>
			Date <input id="date" type="text"><br>
			Subject <input id="subject" type="text"><br>
			Programming languages <input id="languages" type="text"><br>
			Location <input id="location" type="text">

		<p>
			<input type="submit" value="Add session">
		</p>
		</p>
	</form>
	<p>
		<#list pairingSessions as pairingSession>
			${pairingSession.name} <br>
		</#list>
	</p>
</body>
</html>