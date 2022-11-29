var app = new Vue({
    el: "#app",
    vuetify: new Vuetify(),
    data: {
        errorMessages: "",
        Nom: "",
        longitud: 0.0,
        latitud: 0.0,
        state: null,
        zip: null,
        country: null,
        formHasErrors: false,

        user: "",
        pwd: "",
        email: ""
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
        },






        addressCheck() {
            this.errorMessages =
                this.longitud && !this.Nom ? `Hey! I'm required` : "";

            return true;
        },
        resetForm() {
            this.errorMessages = [];
            this.formHasErrors = false;

            Object.keys(this.form).forEach((f) => {
                this.$refs[f].reset();
            });
        },
        submit() {
            this.formHasErrors = false;

            Object.keys(this.form).forEach((f) => {
                if (!this.form[f]) this.formHasErrors = true;

                this.$refs[f].validate(true);
            });
        },

    },
});