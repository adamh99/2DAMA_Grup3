var app = new Vue ({
    el: '#app',
    vuetify : new Vuetify(),
    data:{
        user:"",
        password:"",
        
        name:"",
        email:"",
    },

    methods:{
        getUser:function(){
            const myHeaders = new Headers();

            fetch("node.alumnes.inspedralbes.cat/auth/" + this.user + "/" + this.password, {
            method: "GET",
            headers : myHeaders,
            mode : 'cors'
        }).then(
            (response) =>{
                return response.json(); 
            }
            ).then(
                (data) =>{
                    if(data.auth== true){
                        this.name = data.name;
                        this.email = data.email;
                    }else{
                        this.email = data.email;
                    }}
                ).catch(
                    (error) =>{
                        console.log(error);
                    }
                )
                },   
                
            createUser: function(){
             console.log("create user"); 
             const myHeaders = new Headers();

             fetch("http://localhost:3000/create/" + this.user + "/" + this.pwd, {
                 method: "GET",
                 headers: myHeaders,
                 mode: 'cors',
             }).then(
                 (response) => {
                     return response.json();
                 }
             ).then(
                 (data) => {
                     this.text = data.text;
                 }
             ).catch(
                 (error) => {
                     console.log("ERROR!!");
                     console.log(error);
            })

    

            }}})