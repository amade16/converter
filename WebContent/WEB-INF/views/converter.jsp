<html>
<body bgcolor="#b0e0e6">
	<h2>CONVERTER - APLICA��O PARA CONVERTER ROMANOS EM NUM�RICOS</h2>
	<form action="processarConversao" method="post">
		VALOR ROMANO
		<br />
		<input type="text" name="valor_desejado" />
		<br />
		<br />
		<input type="submit" value="CONVERTER" />
		<br />
		<br />

		VALOR NUM�RICO
		<br />
		<input type="text" name="romano" value="<%=request.getAttribute("valor_convertido")%>" readonly/>
	</form>
</body>
</html>