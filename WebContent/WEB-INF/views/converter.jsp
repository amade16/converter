<html>
<body bgcolor="#b0e0e6">
	<h2>CONVERTER - APLICAÇÃO PARA CONVERTER ROMANOS EM NUMÉRICOS</h2>
	<form action="processarConversao" method="post">
		VALOR ROMANO
		<br />
		<input type="text" name="valor_desejado" />
		<br />
		<br />
		<input type="submit" value="CONVERTER" />
		<br />
		<br />

		VALOR NUMÉRICO
		<br />
		<input type="text" name="romano" value="<%=request.getAttribute("valor_convertido")%>" readonly/>
	</form>
</body>
</html>