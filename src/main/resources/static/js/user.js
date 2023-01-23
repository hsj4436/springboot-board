let index = {
    init: function() {
        $('#btn-save').on('click', () => {
            this.save();
        });
    },

    save: function() {
        let data = {
            userName: $('#userName').val(),
            password: $('#password').val(),
            email: $('#email').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/user/add',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입이 완료되었습니다.');
            window.location.href='/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

index.init();