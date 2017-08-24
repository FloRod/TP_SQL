<!DOCTYPE html>
<html>

<head>
    <title>Formation SQL : TP 1</title>
</head>

<body>

<table border collapse>
		<tr>  <td> nom </td>   <td> date </td>   <td> total </td>    <td> numéro table </td> </tr>
		<#list tabSqlCommande as tab>
				<tr>  <td> ${tab.nom} </td>   <td> ${tab.date} </td>   <td> ${tab.total} </td>    <td> ${tab.numTable} </td> </tr>
		</#list>
</table>
</body>
</html>