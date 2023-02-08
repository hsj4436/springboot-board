let index = {
    init: function() {
        $('#btn-posts-save').on('click', () => {
            this.save();
        });
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
    }
};

index.init();