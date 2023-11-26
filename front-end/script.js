const formulario = document.querySelector("form");
const Inome = document.querySelector("input[name='nome']");
const Iemail = document.querySelector("input[name='email']");
const Isenha = document.querySelector("input[name='senha']");
const Itel = document.querySelector("input[name='tel']");

function cadastrar() {
    fetch("http://localhost:8080/usuarios", 
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            email: Iemail.value,
            senha: Isenha.value,
            telefone: Itel.value,
        })
    })
    .then(function(res) {console.log(res)})
    .catch(function(res) {console.log(res)})
}

function limpar() {
    Inome.value = "";
    Iemail.value = "";
    Isenha.value = "";
    Itel.value = "";
}

formulario.addEventListener('submit', function(event) {
    event.preventDefault();
    cadastrar();
    console.log(Inome.value)

    limpar();
})