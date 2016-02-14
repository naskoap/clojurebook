function deleteImages() {
	//select checked inputs
	var selectedInputs = $("input:checked");
	//grab their ids
	var selectedIds = [];
	selectedInputs.each(function() {
		selectedIds.push($(this).attr('id'));
	});
	if (selectedIds.length < 1)
		alert("No images selected!");
	else
		$.post(context + "/delete",
				{names: selectedIds},
				function(response) {
					var errors = $('<ul>');
					//delete elements if the list of update statuses returned by the server is successful 
					$.each(response, function() {
						if("ok" === this.status) {
						var element = document.getElementById(this.name);
						$(element).parent().parent().remove();
					}
					else
						errors
						.append($('<li>',
								{html: "failed to remove " + 
									   this.name + 
									   ": " + 
									   this.status}));
						});
					if (errors.length > 0)
						$('#error').empty().append(errors);
				},
				"json");
	}

$(document).ready(function(){
	$("#delete").click(deleteImages);
});