<template>
  <div>
    <Layout :style="{padding: '0 24px 24px'}">
      <Breadcrumb :style="{margin: '24px 0'}">
        <BreadcrumbItem>Home</BreadcrumbItem>
        <BreadcrumbItem>Components</BreadcrumbItem>
        <BreadcrumbItem>Layout</BreadcrumbItem>
      </Breadcrumb>
      <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
        Content
      </Content>
    </Layout>
  </div>
</template>

<script>
export default {
  name: 'right',
  data () {
    return {
      pathName: null
    }
  },
  created: function () {
    this.initData()
  },
  computed: {
    key () {
      return this.$route.name !== undefined ? this.$route.name + +new Date() : this.$route + +new Date()
    }
  },
  methods: {
    initData () {
      this.pathName = this.$route.name
    }
  }
}
</script>

<style scoped>

</style>
