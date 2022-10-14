(function(){
    
    $("#tabcidades").on("click",".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnCidadeSim").attr("data-id", botaoClicado.attr("data-id"));
         
        $("#modalcidades").modal("show");

    });

    $("#btnCidadeSim").on("click", function(){
        let botaoSim = $(this); 

        let id = botaoSim.attr("data-id");

        $.ajax({
            url: "/cidades/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/cidades";
            }
        });
    });
})();