window.onload = () => {
    let click = document.querySelector('#click')
    click.onclick = () => {
        click.style.color = "red";
        document.write("<div><strong>클릭</strong>을 하셨습니다</div>");
    }

}