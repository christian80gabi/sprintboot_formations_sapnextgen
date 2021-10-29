// Trigge the Modal of Formation
$('#add-edit-formation').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var recipient = button.data('whatever') // Extract info from data-* attributes

    var modal = $(this)

    modal.find('.modal-title').text('Ajouter une Formation')

    var closeButton = modal.find('#closeButtonFormation')

    closeButton.text('Close')
    closeButton.attr('class', 'btn btn-secondary')
    closeButton.attr('data-dismiss', 'modal')
    closeButton.removeAttr('data-toggle')
    closeButton.removeAttr('data-target')


    if (recipient == 'edit') {
        modal.find('.modal-title').text('Editer une Formation')
        closeButton.text('Delete')
        closeButton.attr('class', 'btn btn-danger')
        closeButton.attr('data-toggle', 'modal')
        closeButton.attr('data-target', '#confirm-modal-formation')
        closeButton.removeAttr('data-dismiss')
    }
})

// Trigge the Modal of Formation
$('#add-edit-experience').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var recipient = button.data('whatever') // Extract info from data-* attributes

    var modal = $(this)

    modal.find('.modal-title').text('Ajouter une Expérience')

    var closeButton = modal.find('#closeButtonExperience')

    closeButton.text('Close')
    closeButton.attr('class', 'btn btn-secondary')
    closeButton.attr('data-dismiss', 'modal')
    closeButton.removeAttr('data-toggle')
    closeButton.removeAttr('data-target')


    if (recipient == 'edit') {
        modal.find('.modal-title').text('Editer une Expérience')
        closeButton.text('Delete')
        closeButton.attr('class', 'btn btn-danger')
        closeButton.attr('data-toggle', 'modal')
        closeButton.attr('data-target', '#confirm-modal-experience')
        closeButton.removeAttr('data-dismiss')
    }
})