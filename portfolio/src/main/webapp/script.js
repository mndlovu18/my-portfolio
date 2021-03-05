async function showMessage(){
    const responseFromServer = await fetch('/message');
    const messageFromeServer = await responseFromServer.text();

    const messageContainer = document.getElementById('about-message');
    messageContainer.textContent = messageFromeServer;
}