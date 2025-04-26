// Array para armazenar os relógios (isso poderia ser uma requisição para o banco de dados)
let listaRelogios = [];

// Função para adicionar um relógio na lista
function adicionarRelogio() {
    const numberRelogioInput = document.getElementById('numberRelogio');
    const manutencaoInput = document.getElementById('manutencao');
    const numberRelogio = numberRelogioInput.value;
    const manutencao = manutencaoInput.value;

    // Verifica se o número do relógio e a manutenção não estão vazios
    if (!numberRelogio || !manutencao) {
        alert("Por favor, insira o número do relógio e a descrição da manutenção.");
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
                tela: data.addressRelogio.includes('TELA') ? 'TELA: MRI' : '', // Verifica se contém "TELA"
                manutencao: manutencao // Adiciona a descrição da manutenção
            };

            // Adiciona o relógio à lista
            listaRelogios.push(formattedRelogio);
            atualizarLista();
        })
        .catch(error => {
            console.error('Erro ao buscar dados do relógio:', error);
            alert('Não foi possível encontrar os dados do relógio.');
        });

    // Limpa os campos de entrada após adicionar
    numberRelogioInput.value = '';
    manutencaoInput.value = '';
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

    // Adiciona os itens da lista na página com um número sequencial
    listaRelogios.forEach((relogio, index) => {
        const li = document.createElement('li');
        li.classList.add('relogioItem');
        li.innerHTML = `<strong>${index + 1} - Relógio ${relogio.numberRelogio} ${relogio.addressRelogio} - Manutenção: ${relogio.manutencao}</strong>`;
        listaUl.appendChild(li);
    });
}
function imprimirLista() {
    const lista = document.getElementById('listaRelogiosUl').innerHTML;
    const janelaImpressao = window.open('', '', 'width=800,height=600');

    janelaImpressao.document.write(`
        <html>
            <head>
                <title>Imprimir Lista de Relógios</title>
                <style>
                    body { font-family: Arial, sans-serif; padding: 20px; }
                    ul { list-style-type: none; padding: 0; }
                    li { margin-bottom: 10px; font-size: 18px; }
                </style>
            </head>
            <body>
                <h2>Lista de Relógios:</h2>
                <ul>${lista}</ul>
            </body>
        </html>
    `);

    janelaImpressao.document.close();
    janelaImpressao.print();
}
