async function showMessage(){
    const responseFromServer = await fetch('/message');
    const messageFromeServer = await responseFromServer.json();

    const messageContainer = document.getElementById('about-message');
    //generate a random index number
    const randomNumber = Math.trunc(Math.random() * 3);
    //display a random fact
    messageContainer.textContent = messageFromeServer[randomNumber];
}