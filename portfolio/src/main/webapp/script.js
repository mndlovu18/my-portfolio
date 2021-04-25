async function showMessage(){
    const responseFromServer = await fetch('/message');
    const messageFromeServer = await responseFromServer.json();

    const messageContainer = document.getElementById('about-message');
    //generate a random index number
    const randomNumber = Math.trunc(Math.random() * 3);
    //display a random fact
    messageContainer.textContent = messageFromeServer[randomNumber];
}

/** Fetches form elements from the server and adds them to the DOM. 
function loadTasks() {
  fetch('/form-list').then(response => response.json()).then((formElements) => {
    const formListElement = document.getElementById('form-list');
    formElements.forEach((formEl) => {
      formListElement.appendChild(createFormElement(formEl));
    })  
  });
}


/** Creates an element that represents a form elements 
function createFormElement(formEl) {
  const formElement = document.createElement('li');
  formElement.className = 'form';

  const titleElement = document.createElement('div');
  titleElement.innerText = formEl.name;

  const emailElement = document.createElement('div');
  emailElement.innerText = formEl.email;

  const messageElement = document.createElement('div');
  messageElement.innerText = formEl.message;

  formElement.appendChild(titleElement);
  formElement.appendChild(emailElement);
  formElement.appendChild(messageElement);

  return formElement;
}*/
