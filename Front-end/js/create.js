var app = new Vue({
    el: '#app',
    vuetify: new Vuetify(),
    data: {
        errorMessages: "",
        Nom: "",
        longitud: 0.0,
        latitud: 0.0,
    
    },



    methods: {
        createProd: function() {
            console.log("create Producte");
            const myHeaders = new Headers();

            fetch(
                    "http://localhost:3000/createProd/" +
                    this.longitud +
                    "/" +
                    this.latitud, +"/" + this.Nom, {
                        method: "GET",
                        headers: myHeaders,
                        mode: "cors",
                    }
                )
                .then((response) => {
                    return response.json();
                })
                .then((data) => {
                    this.text = data.text;
                })
                .catch((error) => {
                    console.log("ERROR!!");
                    console.log(error);
                });
        }
    }
});