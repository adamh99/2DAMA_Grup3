new Vue({
  el: "#app",
  vuetify: new Vuetify(),
  data: () => ({
    errorMessages: "",
    Nom: null,
    longitud: null,
    latitud: null,
    state: null,
    zip: null,
    country: null,
    formHasErrors: false,
    submit: false,
  }),

  computed: {
    form() {
      return {
        Nom: this.Nom,
        longitud: this.longitud,
        latitud: this.latitud,
        state: this.state,
        zip: this.zip,
        country: this.country,
      };
    },
  },

  watch: {
    Nom() {
      this.errorMessages = "";
    },
  },

  methods: {
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
