function changeColorByID(id, color){
    var element = document.getElementById(id);
    element.setAttribute("fill", color);

    var element_text = document.getElementById('texto_' + id);
    if(element_text)
        element_text.children[0].setAttribute("fill", 'white');
}

function changeColor(id, color){
    var elements = document.getElementsByClassName('sala');

    var i;
    for (i = 0; i < elements.length; i++) {
        elements[i].setAttribute("fill", '#fffcd8');

        var element_text = document.getElementById('texto_' + elements[i].getAttribute("id"));
        if(element_text)
            element_text.children[0].setAttribute("fill",'black');
    }

    changeColorByID(id, color);
    goToElement(id);
}

function loadTextByID(id, titulo){
    var element = document.getElementById('texto_' + id);
    element.children[0].textContent = titulo;
}

function goToElement(id){
    var element = document.getElementById(id);

    if (element) {
        var rect = element.getBoundingClientRect();

        var actualTop = $("body").scrollTop();
        if(actualTop == 0)
            actualTop = $("html").scrollTop();

        var actualLeft = $("body").scrollLeft();
        if(actualLeft == 0)
            actualLeft = $("html").scrollLeft();


        var elementWidth = rect.right - rect.left;
        var elementHeight = rect.bottom - rect.top;

        var windowWidth = window.innerWidth;
        var windowHeight = window.innerHeight;

        var top = (actualTop + rect.top) - ((windowHeight - elementHeight) / 2);
        var left = (actualLeft + rect.left) - ((windowWidth - elementWidth) / 2);

        $("html, body").scrollTop(top); //.animate({ scrollTop: top + 'px'});
        $("html, body").scrollLeft(left); //.animate({ scrollLeft: left + 'px'});

    }
}