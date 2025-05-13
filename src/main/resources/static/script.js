
//EXCLUSÃO DO USUARIO - LISTA
document.querySelectorAll('.excluir-usuario').forEach(function(button) {
    button.addEventListener('click',
    function() {
        if (confirm('Confirma a exclusão?')) {

            const row = this.closest('tr'); // Obtém a linha atual da tabela

            const usuarioId = this.dataset.usuarioId;

            // Realize a chamada AJAX para excluir o recurso
            fetch(`/crud/usuario/${usuarioId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => {
                if (response.ok) {
                    // A exclusão foi bem-sucedida
                    console.log('Usuário excluído com sucesso.');

                    // Remove a linha da tabela após a exclusão
                    row.remove();
                } else {
                    // A solicitação DELETE falhou
                    console.error('Erro ao excluir usuário.');
                    alert('Erro ao excluir usuário');
                }
            })
            .catch(error => {
                // Lidar com erros de rede ou outros erros
                console.error('Erro de rede:', error);
                alert('Erro de rede:' + error);
            });
        }
    });
});


//EXCLUSÃO DO PRODUTO - LISTA
document.querySelectorAll('.excluir-produto').forEach(function(button) {
    button.addEventListener('click',
    function() {
        if (confirm('Confirma a exclusão?')) {

            const row = this.closest('tr'); // Obtém a linha atual da tabela

            const produtoId = this.dataset.produtoId;

            // Realize a chamada AJAX para excluir o recurso
            fetch(`/crud/produto/${produtoId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => {
                if (response.ok) {
                    // A exclusão foi bem-sucedida
                    console.log('Produto excluído com sucesso.');

                    // Remove a linha da tabela após a exclusão
                    row.remove();
                } else {
                    // A solicitação DELETE falhou
                    console.error('Erro ao excluir produto.');
                    alert('Erro ao excluir produto');
                }
            })
            .catch(error => {
                // Lidar com erros de rede ou outros erros
                console.error('Erro de rede:', error);
                alert('Erro de rede:' + error);
            });
        }
    });
});

//EXCLUSÃO DO CLIENTE - LISTA
document.querySelectorAll('.delete-client').forEach(function(button) {
    button.addEventListener('click',
    function() {
        if (confirm('Are you confirm?')) {

            const row = this.closest('tr'); // Obtém a linha atual da tabela

            const clienteId = this.dataset.clientId;

            // Realize a chamada AJAX para excluir o recurso
            fetch(`crud/cliente/${clienteId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => {
                if (response.ok) {
                    // A exclusão foi bem-sucedida
                    console.log('Client has been deleted succesfully.');

                    // Remove a linha da tabela após a exclusão
                    row.remove();
                } else {
                    // A solicitação DELETE falhou
                    console.error('Error to delete client.');
                    alert('Error to delete client');
                }
            })
            .catch(error => {
                // Lidar com erros de rede ou outros erros
                console.error('Error from server:', error);
                alert('Error from server:' + error);
            });
        }
    });
});

//EXCLUSÃO DA CATEGORIA - LISTA
document.querySelectorAll('.delete-category').forEach(function(button) {
    button.addEventListener('click',
    function() {
        if (confirm('Are you confirm?')) {

            const row = this.closest('tr'); // Obtém a linha atual da tabela

            const categoriaId = this.dataset.categoryId;

            // Realize a chamada AJAX para excluir o recurso
            fetch(`crud/categoria/${categoriaId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => {
                if (response.ok) {
                    // A exclusão foi bem-sucedida
                    console.log('Category has been deleted succesfully.');

                    // Remove a linha da tabela após a exclusão
                    row.remove();
                } else {
                    // A solicitação DELETE falhou
                    console.error('Error to delete category.');
                    alert('Error to delete category');
                }
            })
            .catch(error => {
                // Lidar com erros de rede ou outros erros
                console.error('Error from server:', error);
                alert('Error from server:' + error);
            });
        }
    });
});

