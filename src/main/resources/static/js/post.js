let index = {
    init: function() {
        $('#btn-posts-save').on('click', () => {
            this.save();
        });
        $('#btn-delete').on('click', () => {
            this.deletePost();
        });
        $('#btn-update').on('click', () => {
            this.updatePost();
        })
    },

    save: function() {
        let data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/post/add',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            window.location.href='/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },

    deletePost: function() {
        let url = window.location.href;
        let id = url.slice(url.lastIndexOf('/') + 1);

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/post/delete/' + id,
            dataType: 'json',
        }).done(function() {
            window.location.href='/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },

    updatePost: function() {
        let id = $('#id').val();

        let data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'PUT',
            url: '/api/v1/post/update/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            window.location.href='/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

index.init();