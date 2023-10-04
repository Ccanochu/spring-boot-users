$(document).ready(function() {
    $('#miTabla').DataTable({
        dom: 'Bfrtip',
        buttons: [
            {
                extend: 'copy',
                className: 'btn btn-primary',
                text: '<i class="fa-solid fa-copy"></i>',
                exportOptions: {
                    columns: ':visible:not(.no-export)' // Oculta las columnas con la clase 'no-export'
                }
            },
            {
                extend: 'csv',
                className: 'btn btn-success',
                text: '<i class="fa-solid fa-file-csv"></i>',
                exportOptions: {
                    columns: ':visible:not(.no-export)' // Oculta las columnas con la clase 'no-export'
                }
            },
            {
                extend: 'excel',
                className: 'btn btn-success',
                text: '<i class="fa-solid fa-file-excel"></i>',
                exportOptions: {
                    columns: ':visible:not(.no-export)' // Oculta las columnas con la clase 'no-export'
                }
            },
            {
                extend: 'pdf',
                className: 'btn btn-danger',
                text: '<i class="fa-solid fa-file-pdf"></i>',
                exportOptions: {
                    columns: ':visible:not(.no-export)' // Oculta las columnas con la clase 'no-export'
                }
            },
            {
                extend: 'print',
                className: 'btn btn-secondary',
                text: '<i class="fa-solid fa-print"></i>',
                exportOptions: {
                    columns: ':visible:not(.no-export)' // Oculta las columnas con la clase 'no-export'
                }
            }
        ]
    });
    
    $('a.btn-danger').on('click', function(e) {
        e.preventDefault();
        var id = $(this).attr('href').split('/').pop();
        confirmarEliminacion(id);
    });

    function confirmarEliminacion(id) {
        Swal.fire({
            title: '¿Estás seguro?',
            text: '¡No podrás revertir esto!',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sí, eliminarlo!'
        }).then((result) => {
            if (result.isConfirmed) {
                eliminarUsuario(id);
            }
        });
    }

    function eliminarUsuario(id) {
        $.ajax({
            url: '/delete/' + id,
            type: 'GET',
            success: function(response) {
                Swal.fire(
                    'Eliminado!',
                    'El usuario ha sido eliminado.',
                    'success'
                );
                window.location.href = '/';
            }
        });
    }
});
