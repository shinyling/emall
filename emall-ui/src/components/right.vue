<template>
  <div class="content-wrapper" style="min-height: 900px;">
    <section class="content-header">
      <h1>
        Dashboard
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/home/home"><i class="fa fa-dashboard"></i>主页</a></li>
        <li class="active">{{pathName}}</li>
      </ol>
    </section>
    <transition name="fade" mode="out-in">
      <section class="content">
        <router-view :key="key"></router-view>
      </section>
    </transition>
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
