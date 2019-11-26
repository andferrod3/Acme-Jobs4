<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="administrator.dashboard.form.label.totalAnnouncements" path="totalAnnouncements"/>
	<acme:form-textbox code="administrator.dashboard.form.label.totalCompanyRecords" path="totalCompanyRecords"/>
	<acme:form-textbox code="administrator.dashboard.form.label.totalInvestorRecords" path="totalInvestorRecords"/>

	<acme:form-money code="administrator.dashboard.form.label.minRewardRequest" path="minRewardRequest"/>
	<acme:form-textbox code="administrator.dashboard.form.label.maxRewardRequest" path="maxRewardRequest"/>
	<acme:form-textbox code="administrator.dashboard.form.label.averageRewardRequest" path="averageRewardRequest"/>
	<acme:form-textbox code="administrator.dashboard.form.labelsdRewardRequest" path="sdRewardRequest"/>
	
	
	<acme:form-textbox code="administrator.dashboard.form.label.minRewardOffer" path="minRewardOffer"/>
	<acme:form-textbox code="administrator.dashboard.form.label.maxRewardOffer" path="maxRewardOffer"/>
	<acme:form-textbox code="administrator.dashboard.form.label.averageRewardOffer" path="averageRewardOffer"/>
	<acme:form-textbox code="administrator.dashboard.form.labelsdMinRewardOffer" path="sdMinRewardOffer"/>	
	<acme:form-textbox code="administrator.dashboard.form.labelsdMaxRewardOffer" path="sdMaxRewardOffer"/>

	
</acme:form>

<div>
	<canvas id="canvas"></canvas>
</div>

<div>
	<canvas id="canvas2"></canvas>
</div>


<script type="text/javascript">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	$(document).ready(function(){
		var data = {
				labels :   [<jstl:forEach var="item" items="${companySectors}" >
								"${item}",
							</jstl:forEach>],  
				datasets: [
					{	label : "Number of Companies in the following sectors",
						data : [<jstl:forEach var="item" items="${companiesPerSector}" >
									<jstl:out value="${item}" />,
								</jstl:forEach>
								]
						
					}
				]
		};
		var options = {
				scales : {
					yAxes : [{
						ticks : {
							suggestedMin: 0.0
						}
					}
					]
				}
		};
		var data2 = {
				labels :   [<jstl:forEach var="item" items="${investorSectors}" >
								"${item}",
							</jstl:forEach>],  
				datasets: [
					{
						label : "Number of Investors in the following sectors",
						data : [<jstl:forEach var="item" items="${investorsPerSector}" >
									<jstl:out value="${item}" />,
								</jstl:forEach>
								]
						
					}
				]
		};
		
		var canvas, context, canvas2, context2;
		
		canvas = document.getElementById("canvas");
		canvas2 = document.getElementById("canvas2")
		context = canvas.getContext("2d");
		context2 = canvas2.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data,
			options : options
		});
		
		new Chart(context2,{
			type : "bar",
			data : data2,
			options : options
		});
		
		
	});
</script>
