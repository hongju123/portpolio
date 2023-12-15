function login() {
    let userData = {
        id: document.querySelector('[name="id"]').value,
        pw: document.querySelector('[name="pw"]').value
    }
    let data = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData),
    }

    fetch('/what/user/login', data)
        .then(response => response.json())
        .then(data => {
            if (data==true) {
                return location.replace("/what/")
            }
            if (data==false) {
                alert("잘못된 입력입니다.")
            }
        }
        )
}