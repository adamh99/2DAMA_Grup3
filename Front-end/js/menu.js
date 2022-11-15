new Vue({
    el: '#menu',
    vuetify: new Vuetify(),
    data: () => ({
      currentItem: 'tab-Web',
      items: [
        {
          name : 'Web',
          children : ['User-Panel']
        }, 
        {
          name : 'Rewards',
          children : ['My Points', 'Rewards']
        },
      
      ],
    
      selectIndexUser: 0,
      itemsUser: [
          { id: 'param', text: 'Paramètres', icon: 'mdi-cog-outline' },
          { id: 'logout', text: 'LOG-OUT', icon: 'mdi-power' },
      ],
    })
  })