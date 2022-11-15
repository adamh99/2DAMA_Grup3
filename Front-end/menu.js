new Vue({
    el: '#menu',
    vuetify: new Vuetify(),
    data: () => ({
      currentItem: 'tab-Web',
      items: [
        {
          name : 'Web',
          children : ['News', 'Maps', 'Books', 'Flights', 'Apps']
        }, 
        {
          name : 'Shopping',
          children : ['Books', 'Flights', 'Apps']
        },
        {
          name : 'Videos',
          children : ['News', 'Flights', 'Apps']
        },
        {
          name : 'Images',
          children : ['News', 'Maps']
        }
      ],
      selectIndexLang: 0,
      itemsLang: [
          { id: 'FR', text: 'France', icon: 'mdi-clock' },
          { id: 'EN', text: 'English', icon: 'mdi-flag' },
      ],
      selectIndexUser: 0,
      itemsUser: [
          { id: 'param', text: 'Paramètres', icon: 'mdi-cog-outline' },
          { id: 'logout', text: 'Déconnection', icon: 'mdi-power' },
      ],
    })
  })