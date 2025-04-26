// Array para armazenar os relógios (isso poderia ser uma requisição para o banco de dados)
let listaRelogios = [];

// Função para adicionar um relógio na lista
function adicionarRelogio() {
    const numberRelogioInput = document.getElementById('numberRelogio');
    const numberRelogio = numberRelogioInput.value;

    // Verifica se o número do relógio não está vazio
    if (!numberRelogio) {
        alert("Por favor, insira o número do relógio.");
        return;
    }

    // Aqui é feita a requisição para o backend para buscar os dados do relógio
    fetch(`/relogios/buscar/${numberRelogio}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Não foi possível encontrar o relógio.");
            }
            return response.json();
        })
        .then(data => {
            // Formata as informações conforme necessário
            const formattedRelogio = {
                numberRelogio: data.numberRelogio,
                addressRelogio: formatAddress(data.addressRelogio),
                tela: data.addressRelogio.includes('TELA') ? 'TELA: MRI' : '' // Verifica se contém "TELA"
            };

            // Adiciona o relógio à lista
            listaRelogios.push(formattedRelogio);
            atualizarLista();
        })
        .catch(error => {
            console.error('Erro ao buscar dados do relógio:', error);
            alert('Não foi possível encontrar os dados do relógio.');
        });

    // Limpa o campo de entrada após adicionar
    numberRelogioInput.value = '';
}

// Função para formatar o endereço de forma simplificada
function formatAddress(address) {
    // Aqui você pode adaptar a forma como o endereço será exibido, por exemplo
    const addressParts = address.split(' / '); // Supondo que o endereço seja separado por ' / '
    return addressParts[0]; // Exibe apenas a primeira parte do endereço
}

// Função para atualizar a lista de relógios na página
function atualizarLista() {
    const listaUl = document.getElementById('listaRelogiosUl');
    listaUl.innerHTML = '';  // Limpa a lista antes de atualizá-la

    // Adiciona os itens da lista na página
    listaRelogios.forEach((relogio, index) => {
        const li = document.createElement('li');
        li.classList.add('relogioItem');
        li.innerHTML = `<strong>Relógio ${relogio.numberRelogio} ${relogio.addressRelogio} `;
        listaUl.appendChild(li);
    });
}
